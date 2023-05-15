import React from "react";
import ActivityList from "../Component/ActivityList";
import Search from "antd/es/input/Search";

const ActivityView: React.FC = () => {

    return (
        <div>
            <Search
                placeholder="input search text"
                allowClear
                enterButton="Search"
                size="large"
                style={{ width: 500, height: 60, margin: "20px auto" }}
            />
            <ActivityList />
        </div>
    );
};
export default ActivityView;