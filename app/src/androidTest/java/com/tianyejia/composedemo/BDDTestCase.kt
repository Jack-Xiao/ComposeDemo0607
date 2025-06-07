package com.tianyejia.composedemo

import io.cucumber.junit.CucumberOptions


@CucumberOptions(
    features = ["features"],  // 相对于 androidTest/assets 的路径
    glue = ["com.tianyejia.composedemo.cucumber.steps"],
    tags = ["@bdd,@smoke,@ui"]
)
class BDDTestCase
