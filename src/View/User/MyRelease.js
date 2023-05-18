// import React, {useState} from "react";
// import {getMyActivities, getMyReleaseActivities} from "../../Services/ActivitySevice";
// import {Button, Card, List, message, Modal} from "antd";
// import {Link, useNavigate, useParams} from "react-router-dom";
// import {getUser} from "../../Services/UserService";
//
// import ReleaseForm from "../../Component/ReleaseForm";
// const default_url = "https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0";
//
// const states= [" ","已报名","已录取","很遗憾，你落选了","已参加","已评价"];// state ENUM('Signed','Passed','Rejected','Participated','Commented'),
//
// class MyRelease  extends React.Component {
//     constructor(props) {
//         super(props);
//         this.state = { myActivities: []};
//     }
//
//     async componentDidMount() {
//         const userId = getUser().userId;
//         const fetchedActivities = await getMyReleaseActivities(userId);
//         //目前fetchedActivities数组只有"userId"，actId，
//         //需要调用getActivityByID补全fetchedActivities的各项信息
//         this.setState({myActivities: fetchedActivities});
//     }
//     render() {
//         return(
//             <div>
//                <ReleaseForm/>
//                 <List
//                     style={{margin: "20px"}}
//                     grid={{gutter: 16, column: 4}}
//                     dataSource={this.state.myActivities}
//                     pagination={{
//                         onChange: page => {
//                             console.log(page);
//                         },
//                         pageSize: 16,
//                     }}
//                     renderItem={(activity) => (
//                         <List.Item>
//                             <Link to={`/activity/${activity.actId}`}>
//                                 <Card
//                                     cover={<img alt={default_url}
//                                                 src={activity.photo? activity.photo: default_url}
//                                                 style={{width: "95%", margin: "0 auto"}}/>}
//                                     title={activity.name}
//
//                                 >
//                                     <Card.Meta description={activity.description}/>
//                                     活动时间：{activity.activityTime}
//                                     <br/>
//                                     <br/>
//                                     {states[activity.state]}
//                                     <br/>
//                                     <br/>
//                                     {activity.state === 4 && <Button>评价活动</Button>}
//                                     {activity.state === 5 && <Button>修改评价</Button>}
//                                 </Card>
//                             </Link>
//                         </List.Item>
//                     )}
//                 />
//             </div>
//
//         )
//     }
//
// };
//
// export default MyRelease;


import React, { useState } from "react";
import { getMyActivities, getMyReleaseActivities, getActivityByID } from "../../Services/ActivitySevice";
import { Button, Card, List, message, Modal } from "antd";
import { Link, useNavigate, useParams } from "react-router-dom";
import { getUser } from "../../Services/UserService";

import ReleaseForm from "../../Component/ReleaseForm";
import myActivity from "./MyActivity";
const default_url = "https://th.bing.com/th/id/R.785580b0aa9cce1c7e016db5ee2e078e?rik=ebpuQj03uKxGQg&riu=http%3a%2f%2fphotos.tuchong.com%2f255820%2ff%2f2852945.jpg&ehk=8sZ0LLnnaIXhdwT1M5Zk2xrfIMFcE%2bV45Nc1839Gj7Y%3d&risl=&pid=ImgRaw&r=0";

const states = [" ", "已报名", "已录取", "很遗憾，你落选了", "已参加", "已评价"]; // state ENUM('Signed','Passed','Rejected','Participated','Commented'),

class MyRelease extends React.Component {
    constructor(props) {
        super(props);
        this.state = { myActivities: [] };
    }

    async componentDidMount() {
        const userId = getUser().userId;
        const fetchedActivities = await getMyReleaseActivities(userId);

        const completeActivities = await Promise.all(
            fetchedActivities.map(async (activity) => {
                const completeActivity = await getActivityByID(activity.actId);
                console.log("得到发布活动")
                console.log(completeActivity)
                return { ...completeActivity };
            })
        );

        this.setState({ myActivities: completeActivities });

    }
    render() {
        return (
            <div>
                <ReleaseForm />
                <List
                    style={{ margin: "20px" }}
                    grid={{ gutter: 16, column: 4 }}
                    dataSource={this.state.myActivities}
                    pagination={{
                        onChange: (page) => {
                            console.log(page);
                        },
                        pageSize: 16,
                    }}
                    renderItem={(activity) => (
                        <List.Item>
                            <Link to={`/activity/${activity.id}`}>
                                <Card
                                    cover={<img alt={default_url} src={activity.photo ? activity.photo : default_url} style={{ width: "95%", margin: "0 auto" }} />}
                                    title={activity.name}
                                >
                                    <Card.Meta description={activity.description} />
                                    活动时间：{activity.activityTime}
                                    <br />
                                    <br />
                                    {states[activity.state]}
                                    <br />
                                    <br />
                                    {activity.state === 4 && <Button>评价活动</Button>}
                                    {activity.state === 5 && <Button>修改评价</Button>}
                                </Card>
                            </Link>
                        </List.Item>
                    )}
                />
            </div>
        );
    }
}

export default MyRelease;
