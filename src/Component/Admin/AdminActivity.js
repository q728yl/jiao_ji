import React, { useEffect } from "react";
import {Card, Button, Modal, Input, Radio} from "antd";
import { useState,setState } from "react";
import { changeStatus } from "../../Services/ActivitySevice";

/**
 * 管理者单个活动视图
 * 被Manage.js调用
 * 被AdminHistoryView.js调用
 * edit by yhx 0513
 */

const ManageActivityView = ({ activity }) => {
    const [activeTabKey, setActiveTabKey] = useState('brief');
    const onTabChange = (key) => {
        setActiveTabKey(key);
    };

    const tabList = [
        {
            key: 'brief',
            tab: '活动简介',
        },
        {
            key: 'detail',
            tab: '活动详情',
        },
    ];

    const contentList = {
        brief: <div>
            活动人数：{activity.recruitmentNumber}
            <br/>
            活动时间：{activity.activityTime}
            <br/>
            组织者：{activity.organizer}
            <br/>
        </div>,
        detail: <div>
            活动人数：{activity.recruitmentNumber }
            <br/>
            活动时间：{activity.activityTime}
            <br/>
            组织者：{activity.organizer}
            <br/>
            活动地点：{activity.location}
            <br/>
            报名时间：{activity.signupTime}
            <br/>
            活动内容：{activity.content}
            <br/>
            限制学院：{activity.college || '无'}
            <br/>   
            限制社团：{activity.club || '无'}
            <br/>
            限制年级：{activity.grade || '无'}
            <br/>
            学分：{activity.suScore}
            <br/>
            劳动学时：{activity.laborHour}
        </div>,
    };
    // useEffect(() => {
    //     changeStatus(activity.id, activity.status, activity.comments, (data, error) => {
    //             if (error) {
    //                 // 如果出现错误，显示错误信息
    //                 console.error(error);
    //             } else {
    //                 // 如果成功获取数据，更新活动列表
    //                 console.log(data);
    //             }
    //         }
    //     );
    // }, [activity.comments, activity.id, activity.status]);
    const handleClick = (activity) => {
        Modal.confirm({
            title: '审核意见',
            content:<div>
                <Radio.Group
                    onChange={(e) => {activity.status = e.target.value;}}
                    defaultValue={'pass'}
                >
                    <Radio value={'pass'}>通过</Radio>
                    <Radio value={'rejected'}>驳回</Radio>
                </Radio.Group>
                <br/>
                <Input
                    type="text"
                    placeholder="审核意见"
                    onChange={(e) => {
                        activity.comments= e.target.value;
                    }}
                />
            </div>,
            okText: '确定',
            cancelText: '取消',
            closable: true,
            icon: null,
            onOk: () => {
                activity.status === 'todo' ? activity.status = 'pass' : activity.status = 'rejected';
                console.log(activity.status);
               // 当前活动状态发到后端
               //  useEffect(() => {
               //      changeStatus(activity.id, activity.status, activity.feedback, (data, error) => {
               //          if (error) {
               //              // 如果出现错误，显示错误信息
               //              console.error(error);
               //          } else {
               //              // 如果成功获取数据，更新活动列表
               //              console.log(data);
               //          }
               //      }
               //      );
               //  }, []);

                fetch('/api/changeStatus', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        "id": activity.id,
                        "status": activity.status,
                        "comments": activity.comments,
                    }),
                })
                    .then(response => response.json())
                    .then(data => {
                        if (data.ok) {
                            // 如果成功获取数据，将数据传递给回调函数
                            //
                            console.log(data.ok)
                        } else {
                            // 如果获取数据失败，将错误信息传递给回调函数
                            console.log(data.msg);
                        }
                    })
                    .catch(error => {
                        // 如果出现错误，将错误信息传递给回调函数
                       console.log(error)
                    });
            },
            onCancel:() => {
                activity.status = 'todo';
            }
        });
    };

    return (
        <div>
            <Card
                style={{ width: '100%' }}
                title={activity.name}
                tabList={tabList}
                activeTabKey={activeTabKey}
                onTabChange={onTabChange}
                tabBarExtraContent={activity.status === 'todo' ?
                    <Button type="primary" onClick={() => handleClick(activity)}>
                        审核
                    </Button>
                    :
                    <div>
                        反馈：{activity.comments}
                    </div>}
            >
                {contentList[activeTabKey]}
            </Card>
        </div>
    );
}

export default ManageActivityView;


