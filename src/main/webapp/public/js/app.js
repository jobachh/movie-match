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
                            <iframe width="560" height="315" src={movie.trailerUrl} frameborder="0" allowfullscreen></iframe>
                        </Col>
                    </Row>
                    <Row>
                        <Col lg={6} lgOffset={3}>
                            <Button block={true}>Recommend another one</Button>
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
    render: function() {
        let movie = this.props.movie;
        return <Col className="movie-element" lg={3}>
                <a href="" className="movie-link">
                    <img className="movie-img" src={movie.imageUrl} height={100} /> <br />
                    {movie.name}
                </a>
            </Col>
    }
});

//caveat: this.props.movies has to be divisible by 4!
var MovieList = React.createClass({
    render: function() {
        var rows = [];
        var movies = this.props.movies;
        for (let i = 0; i < movies.length / 4; ++i) {
            rows.push(<Row className="movie-row"  key={i}>
                <Movie movie={movies[i * 4]} />
                <Movie movie={movies[i * 4 + 1]} />
                <Movie movie={movies[i * 4 + 2]} />
                <Movie movie={movies[i * 4 + 3]} />
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
        var self = this;
        $.ajax({
            url: "http://localhost:8080/api/recommendations/1/viewers/1/genreMovies"
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
                <MovieList movies={this.state.movies} />
                <Grid>
                    <Row>
                        <Col lg={6}>
                            <Button block={true}>Refresh</Button>
                        </Col>
                        <Col lg={6}>
                            <Link to="more-movies">
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
        $.ajax({
            url: "http://localhost:8080/api/recommendations/1/viewers/1/matchedMovies"
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
            <MovieList movies={this.state.movies} />
            <Grid>
                <Row>
                    <Col lg={6}>
                        <Link to="results">
                            <Button block={true} bsStyle="default">Get Results</Button>
                        </Link>
                    </Col>
                    <Col lg={6}>
                        <Link to="/">
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
            var childrenWithProps = React.cloneElement(this.props.children, {recId: this.state.recId});
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