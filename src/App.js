import logo from "./logo.svg";
import "./App.css";
import "./css/backgroud.css";
import LoginView from "./View/LoginView";
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import SignUp from "./View/SignUpView";
import React from "react";
import BasicView from "./View/BasicView";
import ChatView from "./View/ChatView";
import InfoView from "./View/InfoView";
import MomentsView from "./View/MomentsView";
import {Header} from "antd/es/layout/layout";
import ActivityDetail from "./View/DetailView";
import AdminHomeView from "./View/Admin/AdminHomeView";

function App() {
  return (
      <Router>
        <Routes>
          <Route path="/login" element={<LoginView />}/>
          <Route path="/*" element={<BasicView />}/>
            <Route path="/activity/:ActivityId" element={<ActivityDetail />}></Route>
            <Route  path="/signup/:ActivityId" element={<SignUp />} />
          {/*<Route path="/chat" element={<ChatView/>}/>*/}
          {/*<Route path="/info" element={<InfoView/>}/>*/}
          {/*<Route path="/moment" element={<MomentsView/>}/>*/}
        </Routes>
      </Router>
  );
}

export default App;
