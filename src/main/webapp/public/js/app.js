var {Grid, Row, Col, Alert, ButtonToolbar, Button} = ReactBootstrap;
var { Router, Route, IndexRoute, IndexLink, Link } = ReactRouter;

var Result = React.createClass({
    loadResults: function() {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/api/recommendations/"
                + this.props.recId + "/results"
        }).then(function (data) {
            self.setState({
                movies: data
            });
        });
    },

    getInitialState: function() {
        return {
            resultNumber: 0,
            movies: []
        };
    },

    componentDidMount: function() {
        this.loadResults();
    },
    render: function() {
        let movies = this.state.movies;
        if (movies.length > this.state.resultNumber) {
            let movie = movies[this.state.resultNumber];
            return <div>
                <Grid>
                    <Row>
                        <Col lg={12}>
                            <h2>How about watching {movie.name}?</h2>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={2} >
                            <img src={movie.imageUrl} />
                        </Col>
                        <Col lg={10}>
                            <Grid>
                                <Row>
                                    <Col lg={12}>
                                        <h3 className="movie-heading">{movie.name}, {movie.year} (Rating: {movie.rating})</h3>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col lg={12}>
                                        <div className="description">
                                            {movie.description}
                                        </div>
                                    </Col>
                                </Row>
                            </Grid>
                        </Col>
                    </Row>
                    <Row>
                        <Col className="video" lg={6} lgOffset={3}>
                            <iframe width="560" height="315" src={movie.trailerUrl} frameBorder="0" allowFullScreen></iframe>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={6}>
                            <IndexLink to="/"><Button block={true}>Restart</Button></IndexLink>
                        </Col>
                        <Col lg={6}>
                            <Button bsStyle="primary" block={true}>Recommend another one</Button>
                        </Col>
                    </Row>
                </Grid>
            </div>
        } else {
            return <h2>Sorry, we have no more results for you :(</h2>
        }
    }
});

var Movie = React.createClass({
    handleClick: function() {
        this.props.onClick(this.props.movie.movieId);
    },
    render: function() {
        let movie = this.props.movie;
        let modifierClass = this.props.selected ? 'movie-element--selected' : '';
        let onClickFunc = this.handleClick;
        return <Col className={'movie-element ' + modifierClass} lg={3}>
                <a onClick={onClickFunc} className="movie-link">
                    <img className="movie-img" src={movie.imageUrl} height={100} /> <br />
                    {movie.name}
                </a>
            </Col>
    }
});

//caveat: this.props.movies has to be divisible by 4!
var MovieList = React.createClass({
    getInitialState: function() {
        return {selectedMovies: []};
    },
    toggleMovieSelect: function(movieId) {
        let tmpSelectedMovies = this.state.selectedMovies;
        if (tmpSelectedMovies.includes(movieId)) {
            tmpSelectedMovies.splice(tmpSelectedMovies.indexOf(movieId), 1);
        } else {
            tmpSelectedMovies.push(movieId);
        }
        this.setState({selectedMovies: tmpSelectedMovies});
    },
    submit: function() {
        let recId = this.props.recId;
        let currentViewerNumber = this.props.currentViewerNumber;
        $.post({
            url: "http://localhost:8080/api/recommendations/" + recId
            + "/viewers/" + currentViewerNumber + "/likedMovies",
            data: JSON.stringify(this.state.selectedMovies),
            dataType: 'json',
            contentType: "application/json; charset=utf-8"
        });
    },
    render: function() {
        var rows = [];
        var movies = this.props.movies;
        for (let i = 0; i < movies.length / 4; ++i) {
            rows.push(<Row className="movie-row" key={i}>
                <Movie movie={movies[i * 4]}
                       selected={this.state.selectedMovies.includes(this.props.movies[i * 4].movieId)}
                       onClick={this.toggleMovieSelect} />
                <Movie movie={movies[i * 4 + 1]}
                       selected={this.state.selectedMovies.includes(this.props.movies[i * 4 + 1].movieId)}
                       onClick={this.toggleMovieSelect} />
                <Movie movie={movies[i * 4 + 2]}
                       selected={this.state.selectedMovies.includes(this.props.movies[i * 4 + 2].movieId)}
                       onClick={this.toggleMovieSelect} />
                <Movie movie={movies[i * 4 + 3]}
                       selected={this.state.selectedMovies.includes(this.props.movies[i * 4 + 3].movieId)}
                       onClick={this.toggleMovieSelect} />
            </Row>);
        }
        return <div>
            <h2>Pick at least two movies you liked</h2>
            <Grid className="movie-grid">
            {rows}
        </Grid>
        </div>
    }
});

var GenreMovieList = React.createClass({
    loadMovies: function() {
        let self = this;
        let recId = this.props.recId;
        let currentViewerNumber = this.props.currentViewerNumber;
        $.ajax({
            url: "http://localhost:8080/api/recommendations/" + recId
                    + "/viewers/" + currentViewerNumber + "/genreMovies"
        }).then(function (data) {
            self.setState({movies: data});
        });
    },

    getInitialState: function() {
        return {movies: []};
    },

    componentDidMount: function() {
        this.loadMovies();
    },

    render: function() {
        return <div>
                <MovieList ref="movieList" movies={this.state.movies}
                           recId={this.props.recId} currentViewerNumber={this.props.currentViewerNumber}/>
                <Grid>
                    <Row>
                        <Col lg={6}>
                            <Button block={true}>Refresh</Button>
                        </Col>
                        <Col lg={6}>
                            <Link to="more-movies" onClick={() =>this.refs.movieList.submit()}>
                                <Button block={true} bsStyle="primary">Next</Button>
                            </Link>
                        </Col>
                    </Row>
                </Grid>
            </div>
    }
});

var MatchedMovieList = React.createClass({
    loadMovies: function() {
        var self = this;
        let recId = this.props.recId;
        let currentViewerNumber = this.props.currentViewerNumber;
        $.ajax({
            url: "http://localhost:8080/api/recommendations/" + recId
            + "/viewers/" + currentViewerNumber + "/matchedMovies"
        }).then(function (data) {
            self.setState({movies: data});
        });
    },

    getInitialState: function() {
        return {movies: []};
    },

    componentDidMount: function() {
        this.loadMovies();
    },

    render: function() {
        return <div>
            <MovieList ref="movieList" movies={this.state.movies}
                       recId={this.props.recId} currentViewerNumber={this.props.currentViewerNumber}/>
            <Grid>
                <Row>
                    <Col lg={6}>
                        <Link to="results" onClick={() =>this.refs.movieList.submit()}>
                            <Button block={true} bsStyle="default">Get Results</Button>
                        </Link>
                    </Col>
                    <Col lg={6}>
                        <Link to="/" onClick={() =>this.refs.movieList.submit()}>
                            <Button block={true} bsStyle="primary">Add Viewer</Button>
                        </Link>
                    </Col>
                </Row>
            </Grid>
        </div>
    }
});

var MatchApp = React.createClass({
    createRecommendation: function() {
        var self = this;
        $.post({
            url: "http://localhost:8080/api/recommendations"
        }).then(function (data) {
            self.setState({
                recId: data.recId
            });
        });
    },

    getInitialState: function() {
        return {
            recId: -1,
            currentViewerNumber: 1
        };
    },

    componentDidMount: function() {
        this.createRecommendation();
    },

    render: function() {
        if (this.state.recId > 0) {
            var childrenWithProps = React.cloneElement(this.props.children,
                {
                    recId: this.state.recId,
                    currentViewerNumber: this.state.currentViewerNumber
                });
            return <div id="page-wrapper">
                {childrenWithProps}
            </div>
        } else {
            return <Alert>Loading...</Alert>
        }
    }
});

ReactDOM.render(
    <Router>
        <Route path="/" component={MatchApp}>
            <IndexRoute component={GenreMovieList} />
            <Route path="more-movies" component={MatchedMovieList} />
            <Route path="results" component={Result} />
        </Route>
    </Router>
    , document.getElementById('root')
);