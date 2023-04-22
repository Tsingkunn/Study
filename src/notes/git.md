## Git

---
问题:git上已经上传的的文件夹,再在.gitignore中添加该文件夹,结果不生效的问题:

1. 原理解释:.gitignore 中只能添加之前没有被track(add)过的文件,如果文件已经进入了版本管理,那么在.gitignore中添加是无效的.
2. 解决方案:先把本地缓存删除掉(改成未track状态),然后再提交.
   ```
   git rm -r --cached /out
   ```