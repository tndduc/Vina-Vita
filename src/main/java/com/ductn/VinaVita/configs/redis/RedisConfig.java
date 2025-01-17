/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.configs.redis;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *
 * @author Administrator
 */
@Configuration
@EnableCaching
@RequiredArgsConstructor
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    private final ObjectMapper objectMapper;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);

        return new LettuceConnectionFactory(configuration);
    }

    private RedisCacheConfiguration myDefaultCacheConfig(Duration duration) {
        ObjectMapper copy = objectMapper.copy();
        copy.activateDefaultTyping(copy.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(duration)
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.java()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer(copy)));
    }

    @Primary
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration cacheConfig = myDefaultCacheConfig(Duration.ofMinutes(10)).disableCachingNullValues();
        return RedisCacheManager.builder(redisConnectionFactory())
                .cacheDefaults(cacheConfig)
                .build();
    }

    // @Bean
    // public RedisCacheManagerBuilderCustomizer
    // redisCacheManagerBuilderCustomizer() {
    // JacksonTypeReference2JsonRedisSerializer<Set<Person>> serializer = new
    // JacksonTypeReference2JsonRedisSerializer<>(
    // new TypeReference<>() {
    // });
    // RedisCacheConfiguration conf = RedisCacheConfiguration.defaultCacheConfig()
    // .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
    // return builder -> builder.withCacheConfiguration("personCache", conf);
    // }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);

        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }

    // @Primary
    // @Bean
    // public RedisCacheManager cacheManager() {
    // RedisCacheConfiguration cacheConfig =
    // myDefaultCacheConfig(Duration.ofMinutes(10)).disableCachingNullValues();
    // return RedisCacheManager.builder(redisConnectionFactory())
    // .cacheDefaults(cacheConfig)
    // // .withCacheConfiguration("findMedicineCache",
    // myDefaultCacheConfig(Duration.ofMinutes(5)))
    // // .withCacheConfiguration("tutorial",
    // myDefaultCacheConfig(Duration.ofMinutes(1)))
    // .build();
    // }

}
