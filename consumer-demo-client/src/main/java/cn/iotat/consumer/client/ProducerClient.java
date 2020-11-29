package cn.iotat.consumer.client;

import cn.iotat.consumer.external.service.ProducerService;
import cn.iotat.producer.faced.request.model.ItemAddRequest;
import cn.iotat.producer.faced.response.BaseResponse;
import cn.iotat.producer.faced.response.PageData;
import cn.iotat.producer.faced.response.model.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 这个类相当于一个代理类，代理访问ProducerService
 * @author pang
 */
@Component
public class ProducerClient {
    /**
     * FeignClient直接注入即可使用
     */
    @Autowired
    private ProducerService producerService;

    /**
     * 添加新的item
     *
     * @param itemAddRequest 新增item的请求
     * @return 添加是否成功
     */
    public boolean addNewItem(ItemAddRequest itemAddRequest) {
        BaseResponse<Boolean> response = producerService.addNewItem(itemAddRequest);
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
     * @param pageNum 页码
     * @param pageSize 页长
     *
     * @return 包含全部item的列表
     */
    public Collection<ItemInfo> getAllItem(int pageNum, int pageSize) {
        BaseResponse<PageData<ItemInfo>> response = producerService.getAllItem(pageNum, pageSize);
        if (!response.isSuccess()) {
            // TODO 请求失败抛出异常，此为调用外部服务错误
            return null;
        }
        return response.getData().getData();
    }
}
