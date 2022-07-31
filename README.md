# SpringCloud-ACGN

## 技术选型

### 前端

> ---
> 
> - > 基本语言
> 
> - <mark>Vue 3.0 ⬆ || Vue 3.2.37</mark>
> 
> - <mark>Typescript 4.6.4</mark>
> 
> - 
> 
> - > 接口请求
> 
> - <mark>axios  0.27.2 / fetch</mark>
> 
> - 
> 
> - > 路由以及状态管理
> 
> - <mark>vue-router 4.1.3 && pinia 2.0.17</mark>
> 
> - 
> 
> - > style
> 
> - <mark>element-plus 2.2.11</mark>
> 
> - <mark>animate.css 4.1.1</mark>
> 
> - <mark>sass && scss 1.54.0</mark>
> 
> - 
> 
> - > 框架
> 
> - <mark>vite 3.0.0</mark>
> 
> ---

 

### 后端

#### SpringCloud

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <name>SpringCloud-ACGN</name>
    <description>
        ACGN Cloud Project
    </description>

    <groupId>com.hikari</groupId>
    <artifactId>SpringCloud-ACGN</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>

    <modules>
        <module>SpringBoot-Pixivel</module>
        <module>SpringBoot-Commons</module>
        <module>SpringBoot-Framework</module>
        <module>SpringBoot-User</module>
        <module>SpringBoot-Login</module>
    </modules>

    <!-- jdk 17 -->
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencyManagement>
        <dependencies>
            <!-- spring boot parent -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.6.7</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- spring cloud parent -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>2021.0.3</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- spring alibaba cloud parent -->
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>2021.1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>
```

#### SpringBoot-Commons

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringCloud-ACGN</artifactId>
        <groupId>com.hikari</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>SpringBoot-Commons</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Getter Setter ... 快捷开发 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!-- spring boot web 标记 springboot启动 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- String ... 字符工具包 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>

        <!-- swagger3 接口 Api -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>3.0.3</version>
        </dependency>
    </dependencies>

</project>
```

#### SpringBoot-Framework

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>SpringCloud-ACGN</artifactId>
        <groupId>com.hikari</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>SpringBoot-Framework</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>

    </dependencies>
</project>
```

### 数据库

> <mark>Mysql 8 ⬆ || Mysql 8.0.29</mark>

## 目录结构

### SpringCloud

```json
"SpringCloud-ACGN": {
    "SpringBoot-Commons": "基础设计类，工具类",
    "SpringBoot-Framework": "核心配置类",
    "SpringBoot-Login": "登录模块",
    "SpringBoot-Pixivel": "Pixivel模块",
    "SpringBoot-User": "用户模块"
}
```

## 基础配置

### Vue

#### Axios

**axios.ts 核心类**

```typescript
class Axios {
    instance: AxiosInstance
    interceptors?: AxiosInterceptors

    constructor(config: AxiosConfig) {
        this.instance = axios.create(config)
        this.interceptors = config.interceptors

        this.instance.interceptors.request.use(
            this.interceptors?.requestInterceptor,
            this.interceptors?.requestInterceptorCatch
        )
        this.instance.interceptors.response.use(
            this.interceptors?.responseInterceptor,
            this.interceptors?.responseInterceptorCatch
        )

        this.instance.interceptors.request.use(
            (config) => {
                return config
            },
            (error) => {
                return Promise.reject(error)
            }
        )

        this.instance.interceptors.response.use(
            (response) => {
                return response.data
            },
            (error) => {
                return Promise.reject(error)
            }
        )
    }

    request<T>(config: AxiosConfig<T>): Promise<T> {
        return new Promise((resolve, reject) => {
            if (config.interceptors?.requestInterceptor) {
                config = config.interceptors.requestInterceptor(config)
            }

            this.instance
                .request<any, T>(config)
                .then((response) => {
                    if (config.interceptors?.responseInterceptor) {
                        response = config.interceptors.responseInterceptor(response)
                    }
                    resolve(response)
                })
                .catch((error) => {
                    reject(error)
                })
        })
    }

    get<T>(config: AxiosConfig<T>): Promise<T> {
        return this.request<T>({
            ...config,
            method: 'GET'
        })
    }

    post<T>(config: AxiosConfig<T>): Promise<T> {
        return this.request<T>({
            ...config,
            method: 'POST'
        })
    }

    put<T>(config: AxiosConfig<T>): Promise<T> {
        return this.request({
            ...config,
            method: 'PUT'
        })
    }

    delete<T>(config: AxiosConfig<T>): Promise<T> {
        return this.request({
            ...config,
            method: 'DELETE'
        })
    }
}

export default Axios
```

**type.ts 接口自定义**

```typescript
interface AxiosInterceptors<T = AxiosResponse> {
    requestInterceptor?: (config: AxiosRequestConfig) => AxiosRequestConfig
    requestInterceptorCatch?: (error: any) => any
    responseInterceptor?: (response: T) => T
    responseInterceptorCatch?: (error: any) => any
}

interface AxiosConfig<T = AxiosResponse> extends AxiosRequestConfig {
    interceptors?: AxiosInterceptors<T>
}

export type {AxiosInterceptors, AxiosConfig}
```

**key.ts 请求环境**

```typescript
export const axiosKey = {
    dev: 'http://localhost:8080',
}
```

**index.ts 请求出口**

```typescript
export const axios_sm = new Axios({
    baseURL: axiosKey.dev,
    timeout: 5000,
    interceptors: {
        requestInterceptor: (config) => {
            return config
        },
        requestInterceptorCatch(error) {
            return error
        },
        responseInterceptor(response) {
            return response
        },
        responseInterceptorCatch(error) {
            return error
        },
    }
})

export const axios_xs = new Axios({
    baseURL: axiosKey.dev,
    timeout: 5000
})
```

#### Router

**index.ts 路由配置**

```typescript
import {createRouter, createWebHashHistory, RouteRecordRaw} from "vue-router"

declare module 'vue-router' {
    interface RouteMeta {
    }

    interface _RouteRecordBase {
    }
}

export const routes: Array<RouteRecordRaw> = []

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes,
    scrollBehavior(to, from, savedPosition) {

    }
})

export default router
```

#### Theme

**Element-Plus Scss 主题**

**light Scss**

```scss
:root {
    --color-scheme: light;
    --el-color-white: #ffffff;
    --el-color-black: #000000;
    --el-color-primary: #409eff;
    --el-color-primary-light-3: #79bbff;
    --el-color-primary-light-5: #a0cfff;
    --el-color-primary-light-7: #c6e2ff;
    --el-color-primary-light-8: #d9ecff;
    --el-color-primary-light-9: #ecf5ff;
    --el-color-primary-dark-2: #337ecc;
    --el-color-success: #67c23a;
    --el-color-success-light-3: #95d475;
    --el-color-success-light-5: #b3e19d;
    --el-color-success-light-7: #d1edc4;
    --el-color-success-light-8: #e1f3d8;
    --el-color-success-light-9: #f0f9eb;
    --el-color-success-dark-2: #529b2e;
    --el-color-warning: #e6a23c;
    --el-color-warning-light-3: #eebe77;
    --el-color-warning-light-5: #f3d19e;
    --el-color-warning-light-7: #f8e3c5;
    --el-color-warning-light-8: #faecd8;
    --el-color-warning-light-9: #fdf6ec;
    --el-color-warning-dark-2: #b88230;
    --el-color-danger: #f56c6c;
    --el-color-danger-light-3: #f89898;
    --el-color-danger-light-5: #fab6b6;
    --el-color-danger-light-7: #fcd3d3;
    --el-color-danger-light-8: #fde2e2;
    --el-color-danger-light-9: #fef0f0;
    --el-color-danger-dark-2: #c45656;
    --el-color-error: #f56c6c;
    --el-color-error-light-3: #f89898;
    --el-color-error-light-5: #fab6b6;
    --el-color-error-light-7: #fcd3d3;
    --el-color-error-light-8: #fde2e2;
    --el-color-error-light-9: #fef0f0;
    --el-color-error-dark-2: #c45656;
    --el-color-info: #909399;
    --el-color-info-light-3: #b1b3b8;
    --el-color-info-light-5: #c8c9cc;
    --el-color-info-light-7: #dedfe0;
    --el-color-info-light-8: #e9e9eb;
    --el-color-info-light-9: #f4f4f5;
    --el-color-info-dark-2: #73767a;
    --el-bg-color: #ffffff;
    --el-bg-color-page: #f2f3f5;
    --el-bg-color-overlay: #ffffff;
    --el-text-color-primary: #303133;
    --el-text-color-regular: #606266;
    --el-text-color-secondary: #909399;
    --el-text-color-placeholder: #a8abb2;
    --el-text-color-disabled: #c0c4cc;
    --el-border-color: #dcdfe6;
    --el-border-color-light: #e4e7ed;
    --el-border-color-lighter: #ebeef5;
    --el-border-color-extra-light: #f2f6fc;
    --el-border-color-dark: #d4d7de;
    --el-border-color-darker: #cdd0d6;
    --el-fill-color: #f0f2f5;
    --el-fill-color-light: #f5f7fa;
    --el-fill-color-lighter: #fafafa;
    --el-fill-color-extra-light: #fafcff;
    --el-fill-color-dark: #ebedf0;
    --el-fill-color-darker: #e6e8eb;
    --el-fill-color-blank: #ffffff;
    --el-box-shadow: 0px 12px 32px 4px rgba(0, 0, 0, .04), 0px 8px 20px rgba(0, 0, 0, .08);
    --el-box-shadow-light: 0px 0px 12px rgba(0, 0, 0, .12);
    --el-box-shadow-lighter: 0px 0px 6px rgba(0, 0, 0, .12);
    --el-box-shadow-dark: 0px 16px 48px 16px rgba(0, 0, 0, .08), 0px 12px 32px rgba(0, 0, 0, .12), 0px 8px 16px -8px rgba(0, 0, 0, .16);
    --el-disabled-bg-color: var(--el-fill-color-light);
    --el-disabled-text-color: var(--el-text-color-placeholder);
    --el-disabled-border-color: var(--el-border-color-light);
    --el-overlay-color: rgba(0, 0, 0, .8);
    --el-overlay-color-light: rgba(0, 0, 0, .7);
    --el-overlay-color-lighter: rgba(0, 0, 0, .5);
    --el-mask-color: rgba(255, 255, 255, .9);
    --el-mask-color-extra-light: rgba(255, 255, 255, .3);
    --el-border-width: 1px;
    --el-border-style: solid;
    --el-border-color-hover: var(--el-text-color-disabled);
    --el-border: var(--el-border-width) var(--el-border-style) var(--el-border-color);
    --el-svg-monochrome-grey: var(--el-border-color)
}
```

**dark Scss**

```scss
:root {
    --color-scheme: dark;
    --el-color-white: #1B3651;
    --el-color-black: #012447;
    --el-color-primary: #409eff;
    --el-color-primary-light-3: #79bbff;
    --el-color-primary-light-5: #a0cfff;
    --el-color-primary-light-7: #c6e2ff;
    --el-color-primary-light-8: #d9ecff;
    --el-color-primary-light-9: #ecf5ff;
    --el-color-primary-dark-2: #337ecc;
    --el-color-success: #67c23a;
    --el-color-success-light-3: #95d475;
    --el-color-success-light-5: #b3e19d;
    --el-color-success-light-7: #d1edc4;
    --el-color-success-light-8: #e1f3d8;
    --el-color-success-light-9: #f0f9eb;
    --el-color-success-dark-2: #529b2e;
    --el-color-warning: #e6a23c;
    --el-color-warning-light-3: #eebe77;
    --el-color-warning-light-5: #f3d19e;
    --el-color-warning-light-7: #f8e3c5;
    --el-color-warning-light-8: #faecd8;
    --el-color-warning-light-9: #fdf6ec;
    --el-color-warning-dark-2: #b88230;
    --el-color-danger: #f56c6c;
    --el-color-danger-light-3: #f89898;
    --el-color-danger-light-5: #fab6b6;
    --el-color-danger-light-7: #fcd3d3;
    --el-color-danger-light-8: #fde2e2;
    --el-color-danger-light-9: #fef0f0;
    --el-color-danger-dark-2: #c45656;
    --el-color-error: #f56c6c;
    --el-color-error-light-3: #f89898;
    --el-color-error-light-5: #fab6b6;
    --el-color-error-light-7: #fcd3d3;
    --el-color-error-light-8: #fde2e2;
    --el-color-error-light-9: #fef0f0;
    --el-color-error-dark-2: #c45656;
    --el-color-info: #909399;
    --el-color-info-light-3: #b1b3b8;
    --el-color-info-light-5: #c8c9cc;
    --el-color-info-light-7: #dedfe0;
    --el-color-info-light-8: #e9e9eb;
    --el-color-info-light-9: #f4f4f5;
    --el-color-info-dark-2: #73767a;
    --el-bg-color: #1B3651;
    --el-bg-color-page: #1B3651;
    --el-bg-color-overlay: #1B3651;
    --el-text-color-primary: #FFFFFF;
    --el-text-color-regular: #FFFFFF;
    --el-text-color-placeholder: #c0c4cc;
    --el-text-color-secondary: #FFFFFF;
    --el-text-color-disabled: #c0c4cc;
    --el-border-color: #388DE0;
    --el-border-color-light: #388DE0;
    --el-border-color-lighter: #58A9F5;
    --el-border-color-extra-light: #86B3F9;
    --el-border-color-dark: #d4d7de;
    --el-border-color-darker: #cdd0d6;
    --el-fill-color: #012447;
    --el-fill-color-light: #1B3651;
    --el-fill-color-lighter: #1B3651;
    --el-fill-color-extra-light: #1B3651;
    --el-fill-color-dark: #1B3651;
    --el-fill-color-darker: #1B3651;
    --el-fill-color-blank: #1B3651;
    --el-box-shadow: 0px 12px 32px 4px rgba(0, 0, 0, .04), 0px 8px 20px rgba(0, 0, 0, .08);
    --el-box-shadow-light: 0px 0px 12px rgba(0, 0, 0, .12);
    --el-box-shadow-lighter: 0px 0px 6px rgba(0, 0, 0, .12);
    --el-box-shadow-dark: 0px 16px 48px 16px rgba(0, 0, 0, .08), 0px 12px 32px rgba(0, 0, 0, .12), 0px 8px 16px -8px rgba(0, 0, 0, .16);
    --el-disabled-bg-color: var(--el-fill-color-light);
    --el-disabled-text-color: var(--el-text-color-placeholder);
    --el-disabled-border-color: var(--el-border-color-light);
    --el-overlay-color: rgba(0, 0, 0, .8);
    --el-overlay-color-light: rgba(0, 0, 0, .7);
    --el-overlay-color-lighter: rgba(0, 0, 0, .5);
    --el-mask-color: rgba(255, 255, 255, .9);
    --el-mask-color-extra-light: rgba(255, 255, 255, .3);
    --el-border-width: 1px;
    --el-border-style: solid;
    --el-border-color-hover: var(--el-text-color-disabled);
    --el-border: var(--el-border-width) var(--el-border-style) var(--el-border-color);
    --el-svg-monochrome-grey: var(--el-border-color)
}
```

### SpringBoot-Commons

### SpringBoot-Framework

### 基础数据库

**user 用户**

| name        | type         | description  |
| ----------- | ------------ | ------------ |
| id          | varchar(32)  | 主键 雪花        |
| username    | varchar(64)  | 用户名          |
| password    | varchar(255) | 密码           |
| email       | varchar(128) | 邮箱           |
| phone       | varchar(16)  | 手机号          |
| status      | int          | 状态 0 正常 1 禁用 |
| create_time | timestamp    | 创建时间         |

**user_pay 用户钱包**

| name  | type          | description |
| ----- | ------------- | ----------- |
| id    | varchar(32)   | 主键 雪花       |
| money | decimal(10,2) | 余额          |

## Pixivel

#### 介绍

```md

```

### 基本需求

> ---
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> ---

### 重点

> ---
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> - 
> 
> ---

### Vue-Pixivel

### 数据库设计

#### Model





#### Table

**pix_picture 图片**

| name                  | type        | description |
| --------------------- | ----------- | ----------- |
| id                    | varchar(32) | 主键 雪花       |
| sort                  | int         | 排序          |
| picture_collection_id | varchar(32) | 外键 图片集合     |

**pix_picture_detailed 图片详情**

| name       | type         | description          |
| ---------- | ------------ | -------------------- |
| id         | varchar(32)  | 主键 雪花                |
| name       | varchar(256) | 文件名称                 |
| path       | varchar(256) | 路径                   |
| prefix     | varchar(256) | 文件前缀名                |
| suffix     | varchar(32)  | 文件后缀名                |
| height     | int          | 高度px                 |
| width      | int          | 宽度px                 |
| type       | int          | 图片类型 0 插画 1 漫画 2 动图  |
| graphics   | int          | 纵横比 0 横图 1 纵图 2 正方形图 |
| mapping_id | varchar(32)  | 外键 制图工具              |
| picture_id | varchar(32)  | 外键 图片                |

**pix_picture_collection 图片合集**

| name         | type          | description              |
| ------------ | ------------- | ------------------------ |
| id           | varchar(32)   | 主键 雪花                    |
| title        | varcahr(64)   | 标题                       |
| info         | varchar(1280) | 图片说明                     |
| tag_id       | varchar(1280) | 外键 标签                    |
| praise       | int           | 获赞数量                     |
| collect      | int           | 收藏数量                     |
| browse       | int           | 浏览次数                     |
| status       | int           | 状态 0 显示 1 不显示            |
| picture_type | int           | 类型 0 正常作品 1 R-18 2 R-18G |
| pix_user_id  | varchar(32)   | 外键 pixivel用户             |
| create_time  | timestamp     | 创建时间                     |

**pix_tag 标签**

| name       | type         | description |
| ---------- | ------------ | ----------- |
| id         | varchar(32)  | 主键 雪花       |
| name       | varchar(64)  | 名称          |
| other_name | varchar(64)  | 别名          |
| image      | varchar(255) | 标志图         |

**pix_mapping 制图工具**

| name | type        | desscription |
| ---- | ----------- | ------------ |
| id   | varchar(32) | 主键 雪花        |
| name | varchar(64) | 名称           |

**pix_user pixivel用户**

| name        | type         | description |
| ----------- | ------------ | ----------- |
| id          | varchar(32)  | 主键 雪花       |
| nickname    | varchar(64)  | 昵称          |
| avatar      | varchar(256) | 头像          |
| background  | varchar(256) | 背景          |
| description | varchar(256) | 自我介绍        |
| website     | varchar(128) | 个人网站        |
| user_id     | varchar(32)  | 外键 用户       |
| create_time | timestamp    | 创建时间        |

**pix_user_primary pixivel用户会员**

| name        | type        | description  |
| ----------- | ----------- | ------------ |
| id          | varchar(32) | 主键 雪花        |
| primary     | int         | 0 非会员 1 会员   |
| pix_user_id | varchar(32) | 外键 pixivel用户 |
| start_time  | timestamp   | 开通时间         |
| end_time    | timestamp   | 结束时间         |

**pix_user_order pixivel用户订单**

| name         | type          | description                  |
| ------------ | ------------- | ---------------------------- |
| id           | varchar(32)   | 主键 雪花                        |
| order_number | varchar(64)   | 订单编号                         |
| price        | decimal(10,2) | 价格                           |
| context      | varchar(255)  | 购买说明                         |
| status       | int           | 0 订单进行中 1 订单完成 2 订单取消 3 订单超时 |
| pix_user_id  | varchar(32)   | 外键 pixivel用户                 |
| create_time  | timestamp     | 创建时间                         |
| update_time  | timestamp     | 支付 / 取消时间                    |

> 暂定

**pix_user_other_service pixivel用户其他服务**

| name | type        | description |
| ---- | ----------- | ----------- |
| id   | varchar(32) | 主键 雪花       |
|      |             |             |
|      |             |             |

**pix_user_detailed pixivel用户详情**

| name           | type        | description     |
| -------------- | ----------- | --------------- |
| id             | varchar(32) | 主键 雪花           |
| sex            | int         | 性别 0 男 1 女 2 其他 |
| country_id     | varchar(32) | 外键 国家           |
| birthday_year  | timestamp   | 出生年份            |
| birthday_other | timestamp   | 生日              |
| profession_id  | varchar(32) | 外键 职业           |
| pix_user_id    | varchar(32) | 外键 pixivel用户    |

**pix_user_detailed_show pixivel用户详情配置**

| name                | type        | description      |
| ------------------- | ----------- | ---------------- |
| id                  | varchar(32) | 主键 雪花            |
| sex_show            | int         | 0 公开 1 关注可见 2 隐藏 |
| country_show        | int         | 0 公开 1 关注可见 2 隐藏 |
| birthday_year_show  | int         | 0 公开 1 关注可见 2 隐藏 |
| birthday_other_show | int         | 0 公开 1 关注可见 2 隐藏 |
| profession_id_show  | int         | 0 公开 1 关注可见 2 隐藏 |
| collect_show        | int         | 0 公开 1 不公开       |
| pix_user_id         | varchar(32) | 外键 pixivel用户     |

**pix_user_praise 用户点赞**

| name                  | type        | description  |
| --------------------- | ----------- | ------------ |
| id                    | varchar(32) | 主键 雪花        |
| pix_user_id           | varchar(32) | 外键 pixivel用户 |
| picture_collection_id | varchar(32) | 外键 图片合集      |
| create_time           | timestamp   | 点赞时间         |

**pix_user_collect 用户收藏**

| name                  | type          | description  |
| --------------------- | ------------- | ------------ |
| id                    | varchar(32)   | 主键 雪花        |
| pix_user_id           | varchar(32)   | 外键 pixivel用户 |
| picture_collection_id | varchar(32)   | 外键 图片合集      |
| collect_tag           | varchar(2550) | 收藏标签         |
| create_time           | timestamp     | 创建时间         |

**pix_user_featured 用户精选**

| name                  | type        | description  |
| --------------------- | ----------- | ------------ |
| id                    | varchar(32) | 主键 雪花        |
| pix_user_id           | varchar(32) | 外键 pixivel用户 |
| picture_collection_id | varchar(32) | 外键 图片合集      |
| create_time           | varchar(32) | 创建时间         |

> 暂定 --> Booth模块

**pix_user_booth 用户Booth**

| name | type        | description |
| ---- | ----------- | ----------- |
| id   | varchar(32) | 主键 雪花       |
|      |             |             |
|      |             |             |

### SpringBoot-Pixivel

## Music

### Vue-Music

### 数据库设计

### SpringBoot-Music

## Booth

### Vue-Booth

### 数据库设计

### SpringBoot-Booth
