package unit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    public InjectRandomIntBeanPostProcessor() {
        super();
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
