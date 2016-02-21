package io.scalechain.blockchain.api.command.blockchain

import io.scalechain.blockchain.api.command.RpcCommand
import io.scalechain.blockchain.api.domain.{StringResult, RpcError, RpcRequest, RpcResult}
import io.scalechain.blockchain.proto.Hash
import io.scalechain.util.ByteArray

/*
  CLI command :
    bitcoin-cli -testnet getblockhash 240886

  CLI output :
    00000000a0faf83ab5799354ae9c11da2a2bd6db44058e03c528851dee0a3fff

  Json-RPC request :
    {"jsonrpc": "1.0", "id":"curltest", "method": "getblockhash", "params": [240886] }

  Json-RPC response :
    {
      "result": << Same to CLI Output >> ,
      "error": null,
      "id": "curltest"
    }
*/

/** GetBlockHash: returns the header hash of a block at the given height in the local best block chain.
  *
  * https://bitcoin.org/en/developer-reference#getblockhash
  */
object GetBlockHash extends RpcCommand {
  def invoke(request : RpcRequest) : Either[RpcError, Option[RpcResult]] = {
    // TODO : Implement
    val blockHash = Hash("0000000000075c58ed39c3e50f99b32183d090aefa0cf8c324a82eea9b01a887")
    val hashString = ByteArray.byteArrayToString(blockHash.value)
    Right( Some( StringResult(hashString) ) )
  }
  def help() : String =
    """getblockhash index
      |
      |Returns hash of block in best-block-chain at index provided.
      |
      |Arguments:
      |1. index         (numeric, required) The block index
      |
      |Result:
      |"hash"         (string) The block hash
      |
      |Examples:
      |> bitcoin-cli getblockhash 1000
      |> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockhash", "params": [1000] }' -H 'content-type: text/plain;' http://127.0.0.1:8332/
    """.stripMargin
}

