import { Button, Drawer, Radio, Space } from 'antd';
import React, { useState } from 'react';
import PhotoUpload from "./PhotoUpload";
import {InboxOutlined, PlusOutlined} from "@ant-design/icons";
import TextArea from "antd/es/input/TextArea";
const PostMoment = () => {
    const [open, setOpen] = useState(false);
    const [placement] = useState('top');
    const showDrawer = () => {
        setOpen(true);
    };
    const onClose = () => {
        setOpen(false);
    };
    const onCommit = () => {
        setOpen(false);
    };
    return (
        <>
            <Space style={{
                padding: 10,
                width: "100%",
                display: "flex",
                justifyContent: "space-between",
            }}>
                <Button style={{backgroundColor:"rgba(255,255,255,0.5)"}} type="default" shape="circle" icon={<InboxOutlined />} size={'middle'} />

                <Button style={{backgroundColor:"rgba(255,255,255,0.5)"}} type="default" shape="circle" icon={<PlusOutlined />} size={'middle'}
                        onClick={showDrawer}/>
                {/*<Button type="primary" onClick={showDrawer}>*/}
                {/*    Open*/}
                {/*</Button>*/}
            </Space>
            <Drawer
                title=" "
                placement={placement}
                width={500}
                onClose={onClose}
                open={open}
                extra={
                    <Space>
                        <Button type="primary" onClick={onCommit}>
                            发布
                        </Button>
                    </Space>
                }
            >
                <TextArea rows={4} placeholder="发布新的朋友圈吧~"  />
                <br/>  <br/> <br/>
               <PhotoUpload/>
            </Drawer>
        </>
    );
};
export default PostMoment;