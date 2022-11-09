# API接口

> v1.0.0

## POST 消费

POST /payment/balance/consumption

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|balance|query|string| 否 |消费金额|
|remarks|query|string| 否 |备注|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 退款

POST /payment/balance/refund

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|balance|query|string| 否 |退款金额|
|remarks|query|string| 否 |备注|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询用户钱包余额

GET /payment/balance/queryBalance

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询余额历史记录

GET /payment/balanceLog/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pageNo|query|string| 否 |页码|
|pageSize|query|string| 否 |页数|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|





