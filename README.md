ShimmerFix 是一个针对 Shimmer-Noble-21.1 模组的补丁扩展，为原版模块增加实用功能并修复部分问题。当前版本主要增强 MacroProtector 模块，新增玩家靠近自动停用宏的功能。  

## ✨ 功能特性  
## 🛡️ MacroProtector 增强  
玩家靠近保护：当其他真实玩家进入设定范围时，自动停用所有需要关闭的宏（如 AutoFish、Killaura、MiningBot 等）。  
可调节范围：新增 Protect range 滑块，支持 0.0 ~ 100.0 格（设为 0 可禁用）。  
独立开关：新增 Range Protect 开关，可随时开启或关闭靠近保护，不影响原有检测（传送、转头、物品栏变化等）。  
智能重置：开关关闭再打开时自动重置触发状态，确保玩家仍在范围内能再次触发。  
NPC 过滤：利用 Shimmer 自带的 EntityUtil.isNPC() 自动排除村民及特殊玩家，避免误触发。  
无缝集成：所有设置直接显示在原版 MacroProtector 的 GUI 中，与原版设置风格完全一致。  

## 📥 安装  
环境要求  
Minecraft 1.21.10  
Fabric Loader 0.18.4 或更高  
以下模组必须同时安装：  
mods/  
├── fabric-api-0.138.4+1.21.10.jar  
├── Shimmer-Noble-21.1.jar               (Shimmer 本体)  
├── ImmediatelyFast-Fabric-1.13.5+1.21.10.jar  (Shimmer 依赖)  
├── baritone-greencat-fabric-1.21.10.jar       (Shimmer 依赖)  
├── Material-Config-1.21.10-7.jar              (Shimmer 依赖)  
└── shimmerfix-1.0.2.jar                (本补丁模组)  
安装步骤  
下载所有依赖模组（上方列表），放入 .minecraft/mods 文件夹。  
从本仓库的 Releases 下载最新版 shimmerfix-1.0.2.jar，同样放入 mods 文件夹。  
启动游戏，确保 Shimmer 模组正常工作。  
在游戏中打开 Shimmer 菜单，找到 MacroProtector 模块，即可看到新增的 Range Protect 和 Protect range 设置。  

## 🎮 使用方法
启用 MacroProtector：确保模块已开启。  
开启靠近保护：勾选 Range Protect 开关。  
调整触发距离：拖动 Protect range 滑块，设置你希望触发保护的距离（例如 7 格）。  
可选提示：保持 Sound 和 System Tray 开启，在触发时获得音效和系统通知。  
当有其他真实玩家进入你设定的范围时，所有需要停用的宏模块将自动关闭，同时弹出提示（如果启用）。  

## 🔧 开发者信息  
构建  
本项目使用 Fabric Loom 构建，需 JDK 21。  

bash
./gradlew build
生成的 jar 文件位于 build/libs/shimmerfix-1.0.2.jar。

依赖
Shimmer-Noble-21.1.jar（需手动放入 libs/ 目录）

Fabric API 0.138.4+1.21.10

贡献  
欢迎提交 Issue 或 Pull Request。如果你有新的补丁想法，也可以告诉我们。  

## 📜 更新日志
1.0.2 (2025-2-16)
新增：MacroProtector 增加玩家靠近自动停用宏功能。  
添加 Range Protect 开关。  
添加 Protect range 滑块（0.0 ~ 100.0）。  
智能重置机制，开关重开时重新生效。  
自动过滤 NPC，仅针对真实玩家。  
优化：代码重构，使用 Mixin 注入，无需修改原模组文件。  

1.0.0  
初始版本，基础框架搭建。  

## ⚠️ 注意事项  
本模组仅作为 Shimmer 的补丁，必须与指定版本的 Shimmer 本体共同使用，否则可能不兼容。  
请勿将本模组用于恶意目的。  
如遇问题，请先检查依赖模组版本是否完全匹配。  

## 📄 许可证

本项目采用 **ShimmerFix 自定义许可证**，代码公开但保留所有权利。

- ✅ **允许**：查看、学习、个人使用、提交 Pull Request 贡献。
- ⚠️ **需经作者许可**：重新分发（包括修改后发布）、商业使用。

完整许可证条款请参见项目根目录的 [LICENSE](LICENSE) 文件。
