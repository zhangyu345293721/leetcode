# encoding='utf-8'
'''
/**
 * This is the solution of No.860 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/lemonade-change
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * <p>
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * <p>
 * 示例 2：
 * 输入：[5,5,10]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：[10,10]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
'''
from typing import List


class Solution:
    def lemonade_change(self, bills: List[int]) -> bool:
        '''
            计算是否能够换钱
        Args:
            bills: 账单数据-
        Returns:
            布尔值
        '''
        five_money, ten_money = 0, 0
        for bill in bills:
            if bill == 5:
                five_money += 1
            if bill == 10:
                if five_money > 0:
                    five_money -= 1
                    ten_money += 1
                else:
                    return False
            if bill == 20:
                if five_money > 0 and ten_money > 0:
                    five_money -= 1
                    ten_money -= 1
                elif five_money > 2:
                    five_money -= 3
                else:
                    return False
        return True


if __name__ == '__main__':
    bills = [5, 5, 5, 10, 20]
    solution = Solution()
    result = solution.lemonade_change(bills)
    assert result == True
