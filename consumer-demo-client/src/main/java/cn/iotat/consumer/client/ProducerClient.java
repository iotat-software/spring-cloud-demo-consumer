package cn.iotat.consumer.client;

import cn.iotat.consumer.external.service.ProducerService;
import cn.iotat.producer.faced.request.model.ItemForm;
import cn.iotat.producer.faced.response.BaseResponse;
import cn.iotat.producer.faced.response.model.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerClient {
    @Autowired
    private ProducerService producerService;

    /**
     * 添加新的item
     *
     * @param itemForm item表单
     * @return 添加是否成功
     */
    public boolean addNewItem(ItemForm itemForm) {
        BaseResponse<Boolean> response = producerService.addNewItem(itemForm);
        if (!response.isSuccess()) {
            // TODO 请求失败抛出异常，此为调用外部服务错误
            return false;
        }
        return response.getData();
    }

    /**
     * 根据id获取item
     *
     * @param itemId itemId
     * @return itemInfo
     */
    public ItemInfo getItemById(long itemId) {
        BaseResponse<ItemInfo> response = producerService.getItemById(itemId);
        if (!response.isSuccess()) {
            // TODO 请求失败抛出异常，此为调用外部服务错误
            return null;
        }
        return response.getData();
    }

    /**
     * 获取全部item
     *
     * @return 包含全部item的列表
     */
    public List<ItemInfo> getAllItem() {
        BaseResponse<List<ItemInfo>> response = producerService.getAllItem();
        if (!response.isSuccess()) {
            // TODO 请求失败抛出异常，此为调用外部服务错误
            return null;
        }
        return response.getData();
    }
}
