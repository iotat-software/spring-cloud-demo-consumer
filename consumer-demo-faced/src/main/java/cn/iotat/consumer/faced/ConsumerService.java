package cn.iotat.consumer.faced;

import cn.iotat.consumer.request.model.ItemConsumerForm;
import cn.iotat.consumer.response.BaseResponse;
import cn.iotat.consumer.response.model.ItemConsumerInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/api/v1/consumer")
public interface ConsumerService {

    /**
     * 添加新的item
     *
     * @param itemConsumerForm item
     * @return 是否添加成功
     */
    @RequestMapping(method = RequestMethod.POST)
    BaseResponse<Boolean> addNewItem(ItemConsumerForm itemConsumerForm);

    /**
     * 获取全部的item
     *
     * @return 包含全部item的列表
     */
    @RequestMapping(method = RequestMethod.GET)
    BaseResponse<List<ItemConsumerInfo>> getAllItem();

    /**
     * 根据id获取item
     *
     * @param id itemId
     * @return item信息
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    BaseResponse<ItemConsumerInfo> getItemById(@PathVariable Long id);
}
