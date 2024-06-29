<div align=center>

# Survey On Pseudo-Random Number Generators : CS215 Bonus Projects

[中文](#项目介绍) /
[English](#project-introduction)

南方科技大学2023秋季 `CS215 离散数学(H)`附加分课设：[**伪随机数生成器调研报告
**](Docs/Report/黄政东_伪随机数生成器调研报告.pdf)

Southern University of Science and Technology, Autumn 2023
`CS215 Discrete Mathematics(H)` Bonus Project: [**Survey On Pseudo-Random Number Generators
**](Docs/Report/黄政东_伪随机数生成器调研报告.pdf)

对主流伪随机数生成算法进行了调研并实现了相应的Java代码，同时使用[NIST](https://www.nist.gov/)
对伪随机数生成算法效果进行了测试。此外对主流语言/操作系统
所使用的的伪随机数生成算法进行了汇总，最终对伪随机数算法的应用与发展做出展望。

Investigation on mainstream pseudo-random number generation algorithms,
corresponding with Java code implementation. Leverage with [NIST](https://www.nist.gov/), the
effects of the
pseudo-random
number generation algorithms also have been tested. In addition, the pseudo-random number generation
algorithms used in mainstream languages/operating systems are summarised. We finally envisaged the
application and development of pseudorandom number algorithms.

开发列表 / Developers :  [@Frosky Lrupotkin](https://github.com/FrostyHec)

得分 / Score : 4.5/5

</div>

## Project Introduction

### Project Structure

```
SurveyOnPRNGs
├── Codes             
│   ├── PRNGs                   # Java implementations of pseudo-random number generators
│   └── ResultAnalyzeScript     # Script for automatically extracting and organizing NIST test results
├── Docs 
│   └── Report                  # Survey report on pseudo-random number generators                 
├── .gitattributes
├── .gitignore
├── LICENSE
└── README.md
```

### Tasks

The survey completed the following tasks:

- [x] Overview of Pseudo-Random Algorithm
    - [x] Definition
    - [x] Evaluation methods for pseudo-random number generators
        - [x] Quality of random sequences
        - [x] Efficiency of sequence generation
        - [x] Security analysis of random sequences
- [x] Implementation and Quality Assessment of Pseudo-Random Algorithms
    - [x] Common pseudo-random number generation algorithms
        - [x] Middle-square method
            - [x] Original middle-square method
            - [x] Weyl sequence middle-square method
        - [x] Linear congruential generator (LCG)
            - [x] Original LCG
            - [x] Park-Miller algorithm
            - [x] PCG algorithm
        - [x] Lagged Fibonacci generator (LFG)
            - [x] Original LFG
            - [x] Marsaglia's improved LFG
        - [x] Linear feedback shift register (LFSR)
            - [x] Original LFSR
            - [x] Mersenne Twister algorithm
- [x] Cryptographically Secure Pseudo-Random Number Generators (CSPRNG)
    - [x] Blum Blum Shub algorithm
    - [ ] Elliptic curve algorithms
    - [ ] Other CSPRNGs
- [x] Application Survey of Pseudo-Random Number Algorithms
    - [x] Summary of pseudo-random number generation algorithms in mainstream languages/operating
      systems
    - [ ] Quality assessment of PRNGs in mainstream languages/operating systems (partially
      completed)
- [x] Prediction of Pseudo-Random Number Generator Sequences
    - [x] Prediction of Java Random
    - [ ] Prediction of other pseudo-random number generators
- [x] Applications and Prospects of PRNGs
    - [x] Security risk warnings
    - [x] Application analysis
    - [x] Future prospects

## Development Summary

### Technical Summary

Initially, I chose this topic because the LCG prediction discussed in the discrete mathematics
course was quite interesting. I didn't expect that it would require so much knowledge of probability
and statistics. Most of my effort was spent writing the evaluation methods section, relying on the
basic statistical knowledge I learned in the first semester of sophomore year, and referring to NIST
and national standards. Probability and statistics are really quite useful, as they allow
for a quantitative evaluation of the quality of random sequences based on reliable mathematical
derivations. (Maybe I should learn more after courses...)

The design of PRNGs is indeed very ingenious (especially CSPRNGs, which can ensure the security of
PRNGs based on primitives and proofs). Many recent PRNG papers also include proofs of
randomness, which are very well-founded ~~and quite challenging to understand~~.

The process of evaluating PRNGs was actually quite fast. The official NIST documentation contains
some guides. Leverage with Python script for processing results, the entire workflow of 
evaluating PRNGs became very clear and smooth (Only need to focus on Implementing PRNGs, the 
result can be easily collected with required format just by some simple commands).

After the survey, I realized that **any sequence that might be exposed to users should be
evaluated for the risk of prediction and consider switching to CSPRNGs if necessary**. For 
example, in
Java, the RandomInt only requires two consecutive items from the random sequence to predict the
entire subsequent sequence. Even worse, RandomLong only needs one item to predict everything. 
Therefore, many scenarios should use SecureRandom instead of the Random, not just for cryptographic
purposes but also for scenarios like lotteries and verification codes. (It is also important to 
read the notice of using CSPRNGs in Linux/Windows/... to avoid things like entropy exhausted)

Writing the random sequence predictor was quite interesting ~~(but due to time constraints, I only
attempted to predict the Java Random implementation...QAQ)~~

### Postscript

Thanks to the high-quality teaching of the CS211 Discrete Mathematics (H) course (the teacher was
excellent AWA). Maybe in the future, I should learn more about computer mathematics& cryptography.

——Frosty

## 项目介绍

### 项目结构

```
SurveyOnPRNGs
├── Codes             
│   ├── PRNGs                   # 伪随机数算法Java实现
│   └── ResultAnalyzeScript     # 自动提取整理NIST测试结果的脚本
├── Docs 
│   └── Report                  # 伪随机数生成器调研报告                 
├── .gitattributes
├── .gitignore
├── LICENSE
└── README.md
```

### 工作任务

调研主要完成了如下任务

- [x] 伪随机数概述
    - [x] 定义
    - [x] 伪随机数生成器的评价方法
        - [x] 随机序列质量
        - [x] 序列生成效率
        - [x] 随机序列安全性分析
- [x] 伪随机数算法实现与质量评估
    - [x] 普通伪随机数生成算法
        - [x] 平方取中法
            - [x] 原始平方取中法
            - [x] Weyl序列平方取中法
        - [x] 线性同余法
            - [x] 原始LCG
            - [x] Park-Miller算法
            - [x] PCG算法
        - [x] 延迟斐波那契算法
            - [x] 原始LFG
            - [x] Marsaglia改进LFG
        - [x] 线性反馈位移寄存器算法
            - [x] 原始LFSR
            - [x] Mersenne Twister算法
- [x] 密码学安全的伪随机数生成算法
    - [x] Blum Blum Shub算法
    - [ ] 椭圆曲线算法
    - [ ] 更多其它的CSPRNG
- [x] 伪随机数算法应用调研
    - [x] 主流语言/操作系统伪随机数生成算法汇总
    - [ ] 主流语言/操作系统PRNG的质量评估(仅部分完成)
- [x] 伪随机数生成器序列预测
    - [x] Java Random预测
    - [ ] 其它伪随机数生成器预测
- [x] PRNG应用与展望
    - [x] 安全风险提示
    - [x] 应用分析
    - [x] 发展展望

## 开发总结

### 技术总结

最开始选这个题目主要是离散课上讲的LCG预测真的蛮有意思，没想到这玩意其实要那么多概统知识，
主要的精力都放在评价方法部分的撰写上了，凭着大二上学到的浅薄的数理统计知识对着NIST和国标嗯看嗯写，
不得不说概统还是挺有用的，基于可靠的数学推导可以能够量化地评价随机序列质量（只是感觉概统知识实在是不够用
只能推一点点QAQ，好多复杂的统计量真是云里雾里的）

不得不说PRNG的设计都是非常巧妙的（尤其是CSPRNG能够基于原语可证明地保障PRNG的安全性），比较新
的PRNG算法论文很多也包含随机性证明，非常有理有据 ~~且看的头皮发麻~~

PRNG的评估过程其实还蛮快的，NIST的官方文档也算是有写东西~~没写的万能的互联网也有资料~~，
写好处理结果的Python脚本后就只用机械性地 实现PRNG Java版本 => 生成序列 => 跑几条指令拿结果
~~(非常的学术流水线作业)~~

整个调研下来比较有体会的一点是：任何可能被暴露给用户的序列都应该评估序列被预测后的风险并考虑是否改用
CSPRNG，就以Java为例，其RandomInt只需要拿到随机序列的相邻两项就可以预测随后的整个序列，而RandomLong
更是只需要拿到序列一项就全都猜完了(恼)，所以其实很多场景都应该用SecureRandom而不是普通Random(
不只是和密码有关的场景，包括抽奖,验证码等场景都有可能要用CSPRNG，不过这玩意其实也有坑(
比如Linux可能会有熵池耗尽的情况，还是要多加小心))

随机数序列预测器的编写其实还挺有趣的，不过限于时间原因只尝试对Java的Random实现做了预测QAQ，有机会的话看看别
的语言的Random具体实现

### 后记

感谢CS211离散数学(H)这门课的高质量教学（老师讲的好好AWA），感觉后面有时间的话可以多学一学
计算机数学&密码学的相关知识

——Frosty