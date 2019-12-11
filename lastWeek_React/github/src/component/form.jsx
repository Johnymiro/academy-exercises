import React, {Component} from 'react';
import axios from 'axios';
import { Card, CardBody, Button, CardTitle, CardText, CardImg, Container, Row, Col, Table } from 'reactstrap';


class Form extends Component {
    
   state = { value: {
       avatar_url: "./assets/images/images.png"
   } };


    handleSubmit = () => {
        const value = this.input.value;
        let url = `https://api.github.com/users/${value}`;
        
        axios.get(url).then(res => {
            console.log(res);
            this.setState(
               ({value: res.data})
            );
        });
    };


    render(){
        return (

            <Container className="themed-container" fluid="sm" style={{
                marginTop:"100px"
            }}>
                    <Row className="">
                        <Col sm="12" md={{ size: 5, offset: 4 }}>
                            <input type="text" ref={input => (this.input = input)} />
                            <Button color="info" onClick={this.handleSubmit} style={{marginLeft:"5px"}}>Submit</Button>
                        </Col>
                    </Row>
                
                    <Row style={{marginTop:"20px"}}>
                        <Col sm="12" md={{ size: 3, offset: 4 }}> 
                            <Card>
                                <CardImg style={{borderRadius:"50%", padding:"5%"}} src={this.state.value.avatar_url} alt="Card image cap" />
                                <CardBody>
                                    <CardTitle style={{textAlign:"center"}}><b>{this.state.value.name}</b></CardTitle>
                                    <CardText style={{textAlign:"center"}}><small className="text-muted">{this.state.value.location}</small></CardText>
                                    
                                    
                                        <Table borderless >
                                           <thead>
                                               <tr>
                                                   <th>Followers</th>
                                                   <th>Repos</th>
                                                   <th>Stars</th>
                                               </tr>
                                           </thead>
                                           <tbody>
                                               <tr>
                                                    <td>{this.state.value.followers}</td>
                                                    <td>{this.state.value.public_repos}</td>
                                                    <td>{this.state.value.public_gists}</td>
                                               </tr>
                                           </tbody>

                                        </Table>
                                   
                                    <CardText>
                                        <small className="text-muted"></small>
                                    </CardText>
                                </CardBody>
                            </Card>
                        </Col>
                    </Row>

                
            </Container>
        );
    }
}



export default Form;