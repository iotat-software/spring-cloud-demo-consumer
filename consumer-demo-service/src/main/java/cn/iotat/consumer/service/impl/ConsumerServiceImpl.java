package cn.iotat.consumer.service.impl;

import cn.iotat.consumer.client.ProducerClient;
import cn.iotat.consumer.converter.ItemConverter;
import cn.iotat.consumer.faced.api.ConsumerService;
import cn.iotat.consumer.faced.request.model.ConsumerItemAddRequest;
import cn.iotat.consumer.faced.response.BaseResponse;
import cn.iotat.consumer.faced.response.model.ItemConsumerInfo;
import cn.iotat.producer.faced.request.model.ItemAddRequest;
import cn.iotat.producer.faced.response.model.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ProducerClient producerClient;

    /**
     * 添加新的item
     *
     * @param consumerItemAddRequest item
     * @return 是否添加成功
     */
    @Override
    public BaseResponse<Boolean> addNewItem(ConsumerItemAddRequest consumerItemAddRequest) {
        ItemAddRequest itemAddRequest = ItemConverter.converterExternalItemForm(consumerItemAddRequest);
        boolean result = producerClient.addNewItem(itemAddRequest);
        return BaseResponse.success(result);
    }

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    @Override
    public BaseResponse<List<ItemConsumerInfo>> getAllItem(int pageNum,int pageSize) {
        Collection<ItemInfo> itemInfoList = producerClient.getAllItem(pageNum, pageSize);
        List<ItemConsumerInfo> itemConsumerInfoList = ItemConverter.batchConverterAvailableItemInfo(itemInfoList);
        return BaseResponse.success(itemConsumerInfoList);
    }

    /**
     * 根据id获取item
     *
     * @param id itemId
     * @return item信息
     */
    @Override
    public BaseResponse<ItemConsumerInfo> getItemById(Long id) {
        ItemInfo itemInfo = producerClient.getItemById(id);
        ItemConsumerInfo itemConsumerInfo = ItemConverter.converterAvailableItemInfo(itemInfo);
        return BaseResponse.success(itemConsumerInfo);
    }
}
