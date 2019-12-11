// import React, {Component} from 'react';
// import axios from 'axios';
// import {
//     Card, CardImg, CardText, CardBody,
//     CardTitle, CardSubtitle, Button
//   } from 'reactstrap';

// function fetch(url){

//    let api =  `https://api.github.com/search/repositories?q=stars:%3E=10000+language:${url}&sort=stars&order=desc`;
//    return axios.get(api);
// }

// class Post extends Component {

        

//     render(){
//         const {response} = this.props;

//         return (
//             response.forEach( data => {

//                 return(
//                     <div className="container">
//                         <div>
//                             <Card>
//                                 <CardImg top width="100%" src={response.items.owner.avatar_url} alt="Card image cap" />
//                                 <CardBody>
//                                 <CardTitle>card</CardTitle>
//                                 <CardSubtitle>Card subtitle</CardSubtitle>
//                                 <CardText></CardText>
//                                 <Button>Button</Button>
//                                 </CardBody>
//                             </Card>
//                         </div>

//                     </div>
//                 );
//             })
//         );
//     }
// }

// export default Post;