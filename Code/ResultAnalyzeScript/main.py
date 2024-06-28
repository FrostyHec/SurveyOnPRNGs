import re
import csv

# print('please input the raw data')
# input_string = input()

input_string = open('raw_data.txt', 'r').read()

lines = input_string.splitlines()

pattern = r'\s+(?!\*)'

data = [re.split(pattern, line.replace('*', '')) for line in lines]

test_results = {}
for row in data:
    # tst_name
    test_name = row[-1]
    # proportions
    proportions = row[-2].split('/')
    if len(proportions) == 1:
        proportions = [0, 0]
    passed = int(proportions[0])
    total = int(proportions[1])
    # p-value
    p_val_str = row[-3].split(" ")[0]
    p_val = -1
    if p_val_str != '----':
        p_val = float(p_val_str)
    if test_name not in test_results:
        test_results[test_name] = [1, p_val, passed, total]  # cnt,p-value,passed,total
    else:
        test_results[test_name][0] += 1
        test_results[test_name][1] += p_val
        test_results[test_name][2] += passed
        test_results[test_name][3] += total

print('\noutput:')
print('testcase        \t passProp\t avgPv')
file_name = 'output.csv'
with open(file_name, 'w', newline='') as csvfile:
    writer = csv.writer(csvfile)
    for key, value in test_results.items():
        cnt = value[0]
        sum_p_val = value[1]
        passed = value[2]
        total = value[3]
        passProp = (str(passed) + '\\' + str(total))
        if passProp == '0\\0':
            passProp = '/'
        p_val = str(sum_p_val / cnt)
        if p_val == '-1.0':
            p_val = '/'
        row = [key, passProp, p_val]
        print(key + '\t \t' + passProp + '\t ' + p_val + '\t')
        writer.writerow(row)
print('-' * 20)
print(f'输出结果已保存至 {file_name} 文件中')
