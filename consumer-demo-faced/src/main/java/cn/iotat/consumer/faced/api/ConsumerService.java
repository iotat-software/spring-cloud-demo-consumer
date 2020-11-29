package cn.iotat.consumer.faced.api;

import cn.iotat.consumer.faced.request.model.ConsumerItemAddRequest;
import cn.iotat.consumer.faced.response.BaseResponse;
import cn.iotat.consumer.faced.response.model.ItemConsumerInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1/consumer")
public interface ConsumerService {

    /**
     * 添加新的item
     *
     * @param consumerItemAddRequest item
     * @return 是否添加成功
     */
    @RequestMapping(method = RequestMethod.POST)
    BaseResponse<Boolean> addNewItem(ConsumerItemAddRequest consumerItemAddRequest);

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    BaseResponse<List<ItemConsumerInfo>> getAllItem(@RequestParam int pageNum, @RequestParam int pageSize);

    /**
     * 根据id获取item
     *
     * @param id itemId
     * @return item信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    BaseResponse<ItemConsumerInfo> getItemById(@PathVariable Long id);
}
