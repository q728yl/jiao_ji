import React from "react";
import MyUserInfo from "../Component/MyUserInfo";
import DateReminder from "../Component/calendar";
import Notification from "../Component/notification";
import {Content} from "antd/es/layout/layout";

const InfoView: React.FC = () => {

    return (
        <div>
            <Content
                style={{
                    padding: 24,
                    margin: 0,
                    minHeight: 280,
                }}
            >
                {/* <MyCard /> */}
                <h1 className="h1"> 个人信息</h1>
                {/* <UserInfo /> */}
                <MyUserInfo/>
                <h1 className="h1"> 未来日程</h1>
                <DateReminder />
                <h1 className="h1"> 消息通知</h1>
                <Notification />
            </Content>
        </div>
    );
};
export default InfoView;