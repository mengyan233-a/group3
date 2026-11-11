package cn.zhentao.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: dachun
 * @Date: 2026/8/30 - 08 - 30 - 10:53
 * @Description: cn.zhentao.result
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    // 响应码：200成功，其他代表失败
    private Integer code;

    // 提示信息
    private String msg;

    // 返回的数据
    private T data;

    // 成功，返回数据
    public static <T> Result<T> success(T data, String msg) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    // 成功，不返回数据
    public static <T> Result<T> success(String msg) {
        return success(null, msg);
    }

    // 失败
    public static <T> Result<T> fail(Integer code, String msg) {
        Result<T> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }
}
