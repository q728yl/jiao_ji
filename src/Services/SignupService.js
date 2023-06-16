// signupService.js




export function postSignupData(userId,actId,callback) {
    fetch('/api/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            "userId": userId,
            "actId": actId,
        }),
    })
        .then(response => response.json())
        .then(data => {
            if (data.ok) {
                // 如果成功获取数据，将数据传递给回调函数
                alert(data.msg)
            } else {
                // 如果获取数据失败，将错误信息传递给回调函数
                alert(data.msg)
            }
        })
        .catch(error => {
            // 如果出现错误，将错误信息传递给回调函数

        });
}