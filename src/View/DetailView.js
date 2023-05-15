import React, { useEffect, useState } from "react";
import { Button, Col, Row } from "antd";
import { Link, useParams } from "react-router-dom";
import ActivityDetails from "../Component/ActivityDetails";
import { getActivityDetails } from "../Services/ActivitySevice";

function handleSignup() {

}

const ActivityDetail = () => {
    const { ActivityId } = useParams();
    let [activities, setActivity] = useState([]);

    useEffect(() => {
        getActivityDetails((data, error) => {
            if (error) {
                // 如果出现错误，显示错误信息
                console.error(error);
            } else {
                // 如果成功获取数据，更新活动列表
                setActivity(data);
            }
        });
    }, []);

    const activity = activities[ActivityId - 1];
    const handleAddToCartButtonClick = () => {
        // 添加到感兴趣活动列表的逻辑
    };

    return (
        <div>
            <ActivityDetails activity={activity} />
            <div style={{ marginBottom: '20px' }}></div>
            <Row gutter={16}>
                <Col span={12} >
                    <Link to={`http://localhost:3000/signup/${ActivityId}`}>
                        <Button type="primary" style={{marginLeft:'500px'}} onClick={handleSignup}>立刻报名</Button>
                    </Link>
                </Col>
                <Col span={12}>
                    <Button type="primary" onClick={handleAddToCartButtonClick}>
                        添加到感兴趣活动列表
                    </Button>
                </Col>
            </Row>
        </div>
    );
};



export default ActivityDetail;
