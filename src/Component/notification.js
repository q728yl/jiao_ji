
import { Alert, Space } from "antd";
const Notification = () => (
    <Space
        direction="vertical"
        style={{
            width: "100%"
        }}
    >
        <Alert
            message="Success Tips"
            description="Detailed description and advice about successful copywriting."
            type="success"
            showIcon
        />
        <Alert
            message="Informational Notes"
            description="Additional description and information about copywriting."
            type="info"
            showIcon
        />
        <Alert
            message="Warning"
            description="This is a warning notice about copywriting."
            type="warning"
            showIcon
            closable
        />
        <Alert
            message="Error"
            description="This is an error message about copywriting."
            type="error"
            showIcon
        />
    </Space>
);
export default Notification;

