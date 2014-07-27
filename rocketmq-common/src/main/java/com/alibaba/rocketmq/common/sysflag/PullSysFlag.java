/**
 * Copyright (C) 2010-2013 Alibaba Group Holding Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.rocketmq.common.sysflag;

/**
 * Pull接口用到的flag定义
 * 
 * @author shijia.wxr<vintage.wang@gmail.com>
 */
public class PullSysFlag {
    private final static int FLAG_COMMIT_OFFSET = 0x1 << 0;/*chen.si*//*0000 0001*/
    private final static int FLAG_SUSPEND = 0x1 << 1;	   /*chen.si*//*0000 0010*/
    private final static int FLAG_SUBSCRIPTION = 0x1 << 2; /*chen.si*//*0000 0100*/


    public static int buildSysFlag(final boolean commitOffset, final boolean suspend,
            final boolean subscription) {
    	/**
    	 * chen.is 构造pull 的 sysflag，基本的位操作
    	 * 
    	 *     	flag = commitOffset ? flag | FLAG_COMMIT_OFFSET : flag;
    	 *		flag = suspend 		? flag | FLAG_SUSPEND 		: flag;
    	 *		flag = subscription ? flag | FLAG_SUBSCRIPTION 	: flag;
    	 */
        int flag = 0;

        if (commitOffset) {
            flag |= FLAG_COMMIT_OFFSET;
        }

        if (suspend) {
            flag |= FLAG_SUSPEND;
        }

        if (subscription) {
            flag |= FLAG_SUBSCRIPTION;
        }

        return flag;
    }


    public static int clearCommitOffsetFlag(final int sysFlag) {
        return sysFlag & (~FLAG_COMMIT_OFFSET);
    }


    public static boolean hasCommitOffsetFlag(final int sysFlag) {
        return (sysFlag & FLAG_COMMIT_OFFSET) == FLAG_COMMIT_OFFSET;
    }


    public static boolean hasSuspendFlag(final int sysFlag) {
        return (sysFlag & FLAG_SUSPEND) == FLAG_SUSPEND;
    }


    public static boolean hasSubscriptionFlag(final int sysFlag) {
        return (sysFlag & FLAG_SUBSCRIPTION) == FLAG_SUBSCRIPTION;
    }
}
