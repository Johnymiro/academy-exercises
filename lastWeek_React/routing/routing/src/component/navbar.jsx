import React, {Component} from 'react';
import { Button, ButtonGroup } from 'reactstrap';

export default function Nav() {

    
        return(
            <div className="nav">

                <ButtonGroup size="lg">
                    <Button>Home</Button>
                    <Button>Popular Projects</Button>
                    <Button>Developer info</Button>
                </ButtonGroup>


            </div>
        );
    
}