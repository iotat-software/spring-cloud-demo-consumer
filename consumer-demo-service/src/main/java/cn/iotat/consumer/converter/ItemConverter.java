package cn.iotat.consumer.converter;

import cn.iotat.consumer.faced.request.model.ConsumerItemAddRequest;
import cn.iotat.consumer.faced.response.model.ItemConsumerInfo;
import cn.iotat.producer.faced.request.model.ItemAddRequest;
import cn.iotat.producer.faced.response.model.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemConverter {
    /**
     * 将外部的itemInfo转换为系统内部的itemInfo
     *
     * @param itemInfo 外部的itemInfo
     * @return 内部的itemInfo
     */
    public static ItemConsumerInfo converterAvailableItemInfo(ItemInfo itemInfo) {
        ItemConsumerInfo itemConsumerInfo = new ItemConsumerInfo();
        itemConsumerInfo.setId(itemInfo.getId());
        itemConsumerInfo.setName(itemInfo.getName());
        return itemConsumerInfo;
    }

    /**
     * 批量转换itemInfo
     *
     * @param itemInfoList 外部的itemInfo集合
     * @return 内部的itemInfo集合
     */
    public static List<ItemConsumerInfo> batchConverterAvailableItemInfo(Collection<ItemInfo> itemInfoList) {
        List<ItemConsumerInfo> itemConsumerInfoList = new ArrayList<>();
        itemInfoList.forEach(itemInfo -> {
            ItemConsumerInfo itemConsumerInfo = converterAvailableItemInfo(itemInfo);
            itemConsumerInfoList.add(itemConsumerInfo);
        });
        return itemConsumerInfoList;
    }

    /**
     * 将内部的itemForm转换为外部的itemForm
     *
     * @param consumerItemAddRequest 内部的itemForm
     * @return 外部的itemForm
     */
    public static ItemAddRequest converterExternalItemForm(ConsumerItemAddRequest consumerItemAddRequest) {
        ItemAddRequest itemAddRequest = new ItemAddRequest();
        itemAddRequest.setId(consumerItemAddRequest.getId());
        itemAddRequest.setName(consumerItemAddRequest.getName());
        return itemAddRequest;
    }
}
