// import config from 'config';
import { postRequest } from "../utils/ajax";
import { history } from "../utils/history";
import { message } from "antd";
import {useNavigate}  from "react-router-dom";
// import { navigate } from 'gatsby';
// import { navigate } from 'gatsby-link';

export const login = async (data) => {
  const url = ` http://localhost:8003/login`;
  const callback = (data) => {
    if (data.status >= 0) {
      localStorage.setItem("user", JSON.stringify(data.data));
      message.success(data.msg);
      return true;
    } else {
      message.error(data.msg);
      return false;
    }
  };
   const result = await postRequest(url, data, callback);
   return result;
  // localStorage.setItem("user", JSON.stringify(data.data));
  // history.push("/HomeView");
};

export const getUser = () => {
    const user = localStorage.getItem("user");
    if (user) {
      return JSON.parse(user);
    } else {
      return null;
    }
};