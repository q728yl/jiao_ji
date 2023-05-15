// signupService.js

export function postSignupData(requestData) {
    return fetch('/api/handleSignup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    })
        .then(response => response.json())
        .catch(error => {
            console.error(error);
            throw new Error('报名请求失败');
        });
}

