import { Link } from 'react-router-dom';
import {
    Button,
    Divider,
    Grid
  } from "semantic-ui-react";

export function Menu() {
    return (<div className="button1">
                  <h1 className='title'>Blogging platform</h1>
                  <Divider />

        <Grid>
            {/* <Grid.Row centered>
                <Link to='/'><Button basic color='blue'>Blog List</Button></Link>
            </Grid.Row>
            <Grid.Row centered>
                <Link to='/create'><Button basic color='blue'>Create New Post</Button></Link>
            </Grid.Row> */}
            <Grid.Row centered>
                <Link to='/'><Button basic color='blue'>Blog List</Button></Link>
                <Link to='/create'><Button basic color='blue'>Create New Post</Button></Link>
            </Grid.Row>
        </Grid>
    </div>);
}