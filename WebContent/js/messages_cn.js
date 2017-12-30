jQuery.extend(jQuery.validator.messages, {
        required: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>*必填字段</font>",
  remote: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请修正该字段</font>",
  email: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入正确格式的电子邮件</font>",
  url: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入合法的网址</font>",
  date: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入合法的日期</font>",
  dateISO: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入合法的日期 (ISO).</font>",
  number: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入合法的数字</font>",
  digits: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>只能输入整数</font>",
  creditcard: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入合法的信用卡号</font>",
  equalTo: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请再次输入相同的值</font>",
  accept: "&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入拥有合法后缀名的字符串</font>",
  maxlength: jQuery.validator.format("&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入一个 长度最多是 {0} 的字符串</font>"),
  minlength: jQuery.validator.format("&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入一个 长度最少是 {0} 的字符串</font>"),
  rangelength: jQuery.validator.format("&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入 一个长度介于 {0} 和 {1} 之间的字符串</font>"),
  range: jQuery.validator.format("&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入一个介于 {0} 和 {1} 之间的值</font>"),
  max: jQuery.validator.format("&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入一个最大为{0} 的值</font>"),
  min: jQuery.validator.format("&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>请输入一个最小为{0} 的值</font>")
});