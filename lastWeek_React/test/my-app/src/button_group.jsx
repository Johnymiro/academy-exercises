import React from "react";
import { Button, ButtonGroup} from 'reactstrap';
//import Post from "./component/lang_post";



// function fetch(lang){
//    let url =  `https://api.github.com/search/repositories?q=stars:%3E=10000+language:${lang}&sort=stars&order=desc`;

// }

class TopLanguages extends React.Component {

    state = { value: "All" };


    selectLang = () => {

        return (val) => {
            this.setState(
               () => ({value: val})
            );
        }
    };

    selectJS = () => {
        this.setState(
            () => ({ value: "JavaScript"}),
        );
    };

    selectJava = () => {
        this.setState(
            () => ({ value: "Java"}),
        );
    };

    selectHTML = () => {
        this.setState(
            () => ({ value: "HTML"}),
        );
    };

    selectCSS = () => {
        this.setState(
            () => ({ value: "CSS"}),
        );
    };

    selectC = () => {
        this.setState(
            () => ({ value: "C"}),
        );
    };

    selectCPlus = () => {
        this.setState(
            () => ({ value: "C++"}),
        );
    };

    


    render() {

        const languages = ['All', 'JavaScript', 'Java', 'HTML', 'CSS', 'C', 'C++'];
        
        return (
                <div className="container">
                    <ButtonGroup>
                        {languages.map(lang => <ButtonItem key={lang} item={lang} fn={this.selectLang} />)}
                    </ButtonGroup>
                    <h2>{this.state.value}</h2>
                </div>
                
        );
    }
}

export default TopLanguages;

function ButtonItem({item, fn}){

    let state = fn(item);
    return <Button onClick={state}>{item}</Button>;
}

    // <div className="container">
            // <ButtonGroup>

            //     <Button onClick={this.selectAll}>All</Button>
            //     <Button onClick={this.selectJS}>JavaScript</Button>
            //     <Button onClick={this.selectJava}>Java</Button>
            //     <Button onClick={this.selectHTML}>HTML</Button>
            //     <Button onClick={this.selectCSS}>CSS</Button>
            //     <Button onClick={this.selectC}>C</Button>
            //     <Button onClick={this.selectCPlus}>C++</Button>

            // </ButtonGroup>
            // <h2>{this.state.value}</h2>
            // {/* <Post response={this.state.value}/> */}
            // </div>