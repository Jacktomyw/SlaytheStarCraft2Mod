# SlaytheStarCraft2Mod

This is a mod for Slay the Spire in a STARCRAFT II theme.

This mod is still under construction!

Welcome to version 0.1.2!

这个版本中，基本实现了游戏可游玩

1个新角色（星灵）

28张新卡牌（包括起始卡牌）

1个特殊事件（必定在星灵第一层触发，目前只有第二个选项有用）

2个新遗物（都和上面这个特殊事件有关）

图片由于缺少美工只做了一些简单的处理……

(This version still contains potential bugs.)

已知bug：

护盾格挡的伤害不会阻止多层护甲减少，这是因为多层护甲的判断条件里是“如果有 **缓冲** 能力”

（可能解决方案：获得护盾能力时，将护盾能力固定放在ArrayList的第一个，并改为onattacked而不是onlosthp）

已知问题：

单卡查看的升级页面自定义动态变量显示问题