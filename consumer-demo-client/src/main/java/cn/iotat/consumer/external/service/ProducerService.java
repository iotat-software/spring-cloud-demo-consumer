package cn.iotat.consumer.external.service;

import cn.iotat.producer.faced.api.ItemService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "producer-demo")
public interface ProducerService extends ItemService {
}
