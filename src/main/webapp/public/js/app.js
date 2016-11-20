var Grid = ReactBootstrap.Grid;
var Row = ReactBootstrap.Row;
var Col = ReactBootstrap.Col;

var Movie = React.createClass({
    render: function() {
        let movie = this.props.movie;
        return <Col lg={3}>
                <a href="">
                    <img src={movie.imageUrl} height={100} /> <br />
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
            rows.push(<Row key={i}>
                <Movie movie={movies[i]} />
                <Movie movie={movies[i + 1]} />
                <Movie movie={movies[i + 2]} />
                <Movie movie={movies[i + 3]} />
            </Row>);
        }
        return <div>
            <h2>Pick at least two movies you liked</h2>  <Grid>
            {rows}
        </Grid>
        </div>
    }
});

var MOVIES = [
    {name: "Brokeback Mountain", imageUrl: "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY5NTAzNTc1NF5BMl5BanBnXkFtZTYwNDY4MDc3._V1_UX182_CR0,0,182,268_AL_.jpg"},
    {name: "Mission Impossible", imageUrl: "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc3NjI2MjU0Nl5BMl5BanBnXkFtZTgwNDk3ODYxMTE@._V1_UX182_CR0,0,182,268_AL_.jpg"},
    {name: "Men in Black", imageUrl: "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_UY268_CR0,0,182,268_AL_.jpg"},
    {name: "The Hobbit", imageUrl: "https://images-na.ssl-images-amazon.com/images/M/MV5BMTcwNTE4MTUxMl5BMl5BanBnXkFtZTcwMDIyODM4OA@@._V1_UX182_CR0,0,182,268_AL_.jpg"}
];

var MatchApp = React.createClass({
    render: function() {
        return <div id="page-wrapper">
            <MovieList movies={MOVIES}/>
        </div>
    }
});

ReactDOM.render(
<MatchApp />, document.getElementById('root')
);