package cn.iotat.consumer.service.impl;

import cn.iotat.consumer.client.ProducerClient;
import cn.iotat.consumer.converter.ItemConverter;
import cn.iotat.consumer.faced.ConsumerService;
import cn.iotat.consumer.request.model.ItemConsumerForm;
import cn.iotat.consumer.response.BaseResponse;
import cn.iotat.consumer.response.model.ItemConsumerInfo;
import cn.iotat.producer.faced.request.model.ItemForm;
import cn.iotat.producer.faced.response.model.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ProducerClient producerClient;

    /**
     * 添加新的item
     *
     * @param itemConsumerForm item
     * @return 是否添加成功
     */
    @Override
    public BaseResponse<Boolean> addNewItem(ItemConsumerForm itemConsumerForm) {
        ItemForm itemForm = ItemConverter.converterExternalItemForm(itemConsumerForm);
        boolean result = producerClient.addNewItem(itemForm);
        return BaseResponse.success(result);
    }

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    @Override
    public BaseResponse<List<ItemConsumerInfo>> getAllItem() {
        List<ItemInfo> itemInfoList = producerClient.getAllItem();
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
