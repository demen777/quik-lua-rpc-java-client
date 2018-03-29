package com.enfernuz.quik.lua.rpc.events.api;

import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;

/**
 * Компонент, опрашивающий удалённый RPC-сервис <b>quik-lua-rpc</b> на предмет появления новых событий API QLua
 * терминала QUIK.
 * <br/>
 * Связь с <b>quik-lua-rpc</b> происходит по протоколу TCP.
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 */
public interface TcpQluaEventPoller extends QluaEventPoller, TcpGateway {
}
