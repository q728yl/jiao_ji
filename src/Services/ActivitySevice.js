export function getActivityDetails(callback) {
    fetch('/api/activityDetails')
        .then(response => response.json())
        .then(data => {
            if (data.ok) {
                // 如果成功获取数据，将数据传递给回调函数
                callback(data.data);
            } else {
                // 如果获取数据失败，将错误信息传递给回调函数
                callback(null, data.msg);
            }
        })
        .catch(error => {
            // 如果出现错误，将错误信息传递给回调函数
            callback(null, error);
        });
}
export function changeStatus(id, status, comment, callback) {
    fetch('/api/changeStatus', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            "id": id,
            "status": status,
            "comments": comment,
        }),
    })
        .then(response => response.json())
        .then(data => {
            if (data.ok) {
                // 如果成功获取数据，将数据传递给回调函数
                callback(data.data);
            } else {
                // 如果获取数据失败，将错误信息传递给回调函数
                callback(null, data.msg);
            }
        })
        .catch(error => {
            // 如果出现错误，将错误信息传递给回调函数
            callback(null, error);
        });
}