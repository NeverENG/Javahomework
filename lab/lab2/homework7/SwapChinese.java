package homework7;

import java.util.Scanner;

public class SwapChinese {
    
    // 数字对应的中文大写
    private static final String[] DIGITS = {"", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    // 整数单位
    private static final String[] UNITS = {"", "拾", "佰", "仟"};
    // 大额单位
    private static final String[] BIG_UNITS = {"", "万", "亿"};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入金额: ");
        String input = scanner.nextLine().trim();
        
        try {
            // 验证输入格式
            if (!isValidInput(input)) {
                System.out.println("输入错误：金额格式不正确！");
                return;
            }
            
            // 转换为浮点数
            double amount = Double.parseDouble(input);
            
            // 检查是否为负数
            if (amount < 0) {
                System.out.println("输入错误：金额不能为负数！");
                return;
            }
            
            // 转换为中文大写
            String result = convertToChinese(amount);
            System.out.println("转换结果: " + result);
            
        } catch (NumberFormatException e) {
            System.out.println("输入错误：无法解析为有效数字！");
        } catch (Exception e) {
            System.out.println("输入错误：" + e.getMessage());
        }
        
        scanner.close();
    }
    
    // 验证输入格式
    private static boolean isValidInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        
        // 检查是否只包含数字、小数点和前导零
        if (!input.matches("^\\d*\\.?\\d*$")) {
            return false;
        }
        
        // 检查小数点数量
        int dotCount = 0;
        for (char c : input.toCharArray()) {
            if (c == '.') {
                dotCount++;
            }
        }
        if (dotCount > 1) {
            return false;
        }
        
        if (input.contains(".")) {
            String[] parts = input.split("\\.");
            if (parts.length == 2 && parts[1].length() > 2) {
                return false;
            }
        }
        
        return true;
    }
    
    // 主转换方法
    public static String convertToChinese(double amount) {
        // 分离整数部分和小数部分
        long integerPart = (long) amount;
        int decimalPart = (int) Math.round((amount - integerPart) * 100);
        
        StringBuilder result = new StringBuilder();
        
        // 处理整数部分
        if (integerPart == 0 && decimalPart == 0) {
            return "零元整";
        }
        
        if (integerPart > 0) {
            result.append(convertInteger(integerPart));
            result.append("元");
        }
        
        // 处理小数部分
        if (decimalPart > 0) {
            int jiao = decimalPart / 10;
            int fen = decimalPart % 10;
            
            if (jiao > 0) {
                result.append(DIGITS[jiao]).append("角");
            }
            
            if (fen > 0) {
                result.append(DIGITS[fen]).append("分");
            }
        } else {
            // 没有小数部分，添加"整"字
            result.append("整");
        }
        
        return result.toString();
    }
    
    // 转换整数部分
    private static String convertInteger(long num) {
        if (num == 0) {
            return "零";
        }
        
        StringBuilder result = new StringBuilder();
        int bigUnitIndex = 0;
        
        // 从低位到高位处理，每4位一组
        while (num > 0) {
            long section = num % 10000;
            if (section != 0) {
                String sectionStr = convertSection(section);
                if (bigUnitIndex > 0) {
                    sectionStr += BIG_UNITS[bigUnitIndex];
                }
                result.insert(0, sectionStr);
            } else {
                // 处理连续的0
                if (result.length() > 0 && !result.toString().startsWith("零")) {
                    result.insert(0, "零");
                }
            }
            num /= 10000;
            bigUnitIndex++;
        }
        
        // 特殊处理：10-19的情况
        String resultStr = result.toString();
        if (resultStr.startsWith("壹拾") && resultStr.length() <= 4) {
            resultStr = resultStr.substring(1); // 去掉"壹"，变成"拾"
        }
        
        return resultStr;
    }
    
    // 转换四位以内的数字
    private static String convertSection(long num) {
        if (num == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int unitIndex = 0;
        boolean needZero = false;
        
        while (num > 0) {
            int digit = (int) (num % 10);
            if (digit > 0) {
                if (needZero) {
                    result.insert(0, "零");
                    needZero = false;
                }
                result.insert(0, DIGITS[digit] + UNITS[unitIndex]);
            } else {
                if (result.length() > 0) { // 只有在已经有数字的情况下才需要记录零
                    needZero = true;
                }
            }
            num /= 10;
            unitIndex++;
        }
        
        return result.toString();
    }
}