package cn.iotat.consumer.external.service;

import cn.iotat.producer.faced.api.ItemService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 因为本项目导入了producer-demo-faced这个依赖，
 * 因此是可以直接取到该依赖下的所有类的
 *
 * 此处是一个Feign客户端，继承ItemService是因为要统一访问路径、参数以及返回值
 * {@link FeignClient}注解的值为目标服务在nacos上注册的名字，一般为对应系统的spring.application.name
 *
 * @author pang
 */
@FeignClient(value = "producer-demo")
public interface ProducerService extends ItemService {
}
