import logo from './logo.svg';
import './App.css';
import React from 'react';
import { HashRouter, Route, Routes } from 'react-router-dom';
import { ViewPosts } from './Components/ViewPosts';
import { CreatePost } from './Components/CreatePost';
import { SeePost } from './Components/SeePost';
import { CreateComment } from './Components/CreateComment';
import { ViewComments } from './Components/ViewComments';
import { Menu } from './Components/Menu';
import 'semantic-ui-css/semantic.min.css';
import {
  Button,
  ButtonGroup,
  Confirm,
  Divider,
  Grid,
  Icon,
  Input,
  Segment,
  Table,
  List,
  Card,
  Container
} from "semantic-ui-react";

function App() {
  return (
    <div className="App">
        <HashRouter>
        <Divider hidden></Divider>
        <Routes>
          <Route path="/create" element={<CreatePost/>} />
          <Route path='/' element={<ViewPosts />} />
          <Route path='/view/:id' element={<SeePost />} />
          <Route path='/createComment' element={<CreateComment />} />
          <Route path='/comments' element={<ViewComments />} />
        </Routes>

      </HashRouter>
    </div>
  );
}

export default App;
