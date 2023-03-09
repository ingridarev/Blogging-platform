import { Link } from 'react-router-dom';
import { Button, Grid} from "semantic-ui-react";


export function Menu() {
    return (<div className="button1">
                  <h2 className='title'>Blogging platform</h2>

        <Grid>
            <Grid.Row centered>
                <Link to='/'><Button basic color='blue'>Blog List</Button></Link>
            </Grid.Row>
            <Grid.Row centered>
                <Link to='/create'><Button basic color='blue'>Create New Post</Button></Link>
            </Grid.Row>
        </Grid>
    </div>);
}