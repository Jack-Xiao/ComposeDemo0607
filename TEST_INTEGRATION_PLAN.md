# Cucumber + UiTest + Snapshot 测试集成计划
## XML + Compose 混合架构

## 项目概述
针对XML + Compose混合Android项目的完整测试集成方案：
- **Cucumber**: BDD场景测试，支持XML和Compose组件
- **UiTest**: 混合UI自动化测试（Espresso + Compose Test）
- **Snapshot测试**: 同时支持XML视图和Compose组件的快照测试

## 技术栈选择（混合架构优化）

### 1. Cucumber框架
- **cucumber-android**: 4.9.0+ (稳定支持Android)
- **cucumber-java8**: Lambda表达式支持
- **cucumber-junit-platform-engine**: JUnit 5集成

### 2. 混合UI测试框架
- **Espresso**: XML视图测试 (androidx.test.espresso)
- **Compose UI Test**: Compose组件测试 (androidx.compose.ui:ui-test-junit4)
- **UiAutomator**: 跨视图系统测试 (androidx.test.uiautomator)
- **Barista**: 简化Espresso API（可选）

### 3. 混合Snapshot测试
- **Shot**: 支持XML视图截图 (com.karumi:shot)
- **Compose Screenshot Testing**: Compose组件截图
- **Roborazzi**: 统一截图测试框架（推荐，同时支持XML和Compose）

## 实施步骤详解

### Step 1: 配置Cucumber依赖和基础设置
**目标**: 建立BDD测试基础，支持混合架构

**具体任务**:
1. 添加Cucumber相关依赖到 `libs.versions.toml`
2. 配置 `build.gradle.kts` 测试依赖和插件
3. 创建CucumberTestRunner支持混合测试
4. 设置Android Test Orchestrator
5. 创建feature文件目录结构

**关键配置**:
```kotlin
testInstrumentationRunner = "com.tianyejia.composedemo.CucumberTestRunner"
testInstrumentationRunnerArguments["clearPackageData"] = "true"
```

### Step 2: 设置混合UiTest框架
**目标**: 同时支持XML视图和Compose组件的UI测试

**具体任务**:
1. 配置Espresso + Compose UI Test依赖
2. 创建混合页面对象模式（Page Objects）
3. 实现Cucumber Step Definitions支持两种UI类型
4. 创建ViewMatcher和ComposeTestRule工具类
5. 设置测试数据和状态管理

**架构设计**:
- BasePageObject: 抽象基类
- XmlPageObject: XML视图专用
- ComposePageObject: Compose组件专用
- HybridPageObject: 混合视图页面

### Step 3: 集成混合Snapshot测试
**目标**: 统一的截图测试解决方案

**具体任务**:
1. 集成Roborazzi作为主要截图框架
2. 配置XML视图截图规则
3. 设置Compose组件截图测试
4. 建立截图命名和组织规范
5. 实现截图对比和更新机制

**截图策略**:
- 设备无关截图配置
- 主题和暗黑模式覆盖
- 不同屏幕密度适配

### Step 4: 创建完整测试示例
**目标**: 验证混合架构测试能力

**具体任务**:
1. 创建包含XML和Compose的示例页面
2. 编写涵盖两种UI的Feature文件
3. 实现导航和交互测试
4. 添加表单验证和数据流测试
5. 创建端到端用户旅程测试

**测试场景示例**:
- XML Activity → Compose Fragment
- 数据在XML和Compose间传递
- 混合导航流程测试

### Step 5: 优化和CI/CD集成
**目标**: 生产就绪的测试流程

**具体任务**:
1. 优化测试执行性能
2. 配置并行测试执行
3. 设置分层测试报告
4. 集成代码覆盖率统计
5. 建立测试维护策略

## 混合架构特殊考虑

### 1. 测试隔离策略
```kotlin
// XML视图测试
@get:Rule
val activityRule = ActivityScenarioRule(MainActivity::class.java)

// Compose测试
@get:Rule
val composeTestRule = createComposeRule()

// 混合测试
@get:Rule
val hybridTestRule = createHybridTestRule()
```

### 2. 选择器策略
- XML: 使用resource-id, className, text
- Compose: 使用semantics, testTag, contentDescription
- 统一: UiAutomator选择器

### 3. 同步机制
- IdlingResource for XML async operations
- ComposeIdlingResource for Compose animations
- 统一等待策略

## 目录结构
```
app/src/
├── androidTest/
│   ├── java/com/tianyejia/composedemo/
│   │   ├── cucumber/
│   │   │   ├── CucumberTestRunner.kt
│   │   │   ├── steps/
│   │   │   │   ├── XmlSteps.kt
│   │   │   │   ├── ComposeSteps.kt
│   │   │   │   └── HybridSteps.kt
│   │   │   ├── pages/
│   │   │   │   ├── base/
│   │   │   │   ├── xml/
│   │   │   │   ├── compose/
│   │   │   │   └── hybrid/
│   │   │   └── hooks/
│   │   ├── screenshots/
│   │   └── utils/
│   └── assets/
│       └── features/
├── test/
│   └── java/com/tianyejia/composedemo/
│       ├── screenshot/
│       └── unit/
└── screenshots/ (生成的截图文件)
```

## 验证标准

### 每步验证
1. **编译通过**: 混合依赖无冲突
2. **XML测试**: 传统Espresso测试正常
3. **Compose测试**: Compose UI测试正常  
4. **混合测试**: 跨UI系统交互测试
5. **截图测试**: 两种UI类型截图对比

### 最终目标
- 完整的BDD混合测试覆盖
- 统一的测试执行和报告
- 可维护的测试代码架构
- 高效的CI/CD集成