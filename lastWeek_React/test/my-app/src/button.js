import React from 'react';

class Counter extends React.Component{

    state = {value: 0};


    increment = () => {
        this.setState(
            prevState => ({ value: prevState.value + 1}),
        
        );
    };


    decrement = () => {
        this.setState(
            prevState => ({ value: prevState.value - 1}),
        );
    };


    reset = () => {
        this.setState(
            { value: 0},
            this.stateUpdateCb
        );
    };


    render(){
        const {className} = this.props;
        return (
            <div className="container">
                <h2>{this.state.value}</h2>
                <button className="btn btn-success" onClick={this.increment}>Increment</button> 
                <button className="btn btn-primary" onClick={this.decrement}>Decrement</button> 
                <button className="btn btn-warning" onClick={this.reset}>Reset</button> 
            </div>
        );
    }
}

export default Counter;