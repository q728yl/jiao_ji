import { Layout, Menu, Input } from "antd";
import React, {useState} from "react";
import ActivityList from "../../Component/ActivityList";
import PersonView from "../PersonView";
import ActivityView from "../ActivityView";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import LoginView from "../LoginView";
import SignUp from "../SignUpView";
import BasicView from "../BasicView";
import ChatView from "../ChatView";
import InfoView from "../InfoView";
import MomentsView from "../MomentsView";

const { Header, Content } = Layout;
const { Search } = Input;

const items = [
    {
        label: "活动大厅",
        key: "home",
        path: "/",
        // component: ActivityView,
    },
    {
        label: "个人中心",
        key: "person",
        path: "/info",
        // component: PersonView,
    },
    {
        label: "管理活动",
        key: "manage",
        path: "/manage",
        // component: PersonView,
    },
    {
        label: "聊天室",
        key: "chat",
        path: "/chat",
        // component: ChatView,
    },
];

/**
 * @description: 活动页面
 * 顶部菜单栏+活动列表
 * 包含组件ActivityList：活动列表
 * 页面跳转未完成
 */
const HomeView = () => {
    const [selectedKey, setSelectedKey] = useState("home");

    const handleMenuClick = ({ key }) => {
        setSelectedKey(key);
    };
    return (
        <div>
            <Layout className="background">
                <Header   style={{backgroundColor: "rgb(240,248,255)"}}>
                    <Menu
                        theme={"light"}
                        mode="horizontal"
                        selectedKeys={[selectedKey]}
                        onClick={handleMenuClick}
                        defaultSelectedKeys={["home"]}
                        style={{ lineHeight: "64px" ,backgroundColor: 'rgb(255,255,255,0)'}}
                    >
                        {/*{items.map((item) => (*/}
                        {/*    <Menu.Item key={item.key}>{item.label}</Menu.Item>*/}
                        {/*))}*/}
                        <Menu.Item key="home">
                            <Link to="/">活动大厅</Link>
                        </Menu.Item>
                        <Menu.Item key="person">
                            <Link to="/info">个人中心</Link>
                        </Menu.Item>
                        <Menu.Item key="moment">
                            <Link to="/moment">朋友圈</Link>
                        </Menu.Item>
                        <Menu.Item key="chat">
                            <Link to="/chat">聊天室</Link>
                        </Menu.Item>
                    </Menu>
                </Header>
                <Routes>
                    <Route path="/" element={<ActivityView />} />
                    <Route path="/chat" element={<ChatView />} />
                    <Route path="/info" element={<InfoView />} />
                    <Route path="/moment" element={<MomentsView />} />
                </Routes>

                {/*<Content className="background">*/}
                {/*    <div style={{ width:'100%' }}>*/}
                {/*        {items.map((item) =>*/}
                {/*            item.key === selectedKey ? item.content : null*/}
                {/*        )}*/}
                {/*    </div>*/}
                {/*</Content>*/}
            </Layout>
        </div>
    );
};

export default HomeView;