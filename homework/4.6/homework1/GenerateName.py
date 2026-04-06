import random

# 1. 准备字库
surnames = ['赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨']
names = ['杰', '伦', '轩', '豪', '然', '伟', '静', '娜', '敏', '强', '洋', '艳', '娟', '磊', '军', '涛', '明', '超', '秀', '兰','宇轩','子涵','梓萱','子墨','子琪','子睿','子豪','子轩','子杰','子凡','子辰','子璇','子萱','子涵','子墨','子琪']


results = []

def generate_name(num):
    for _ in range(num):
        surname = random.choice(surnames)
        name = random.choice(names)
        full_name = surname + name
        results.append(full_name)
    with open('students.txt', 'w', encoding='utf-8') as f:
        for name in results:
            f.write(name + '\n')

if __name__ == "__main__":
    num = 10000  # 生成100个名字
    generate_name(num)
    print(f"已生成 {num} 个名字，并保存到 students.txt 文件中。")  