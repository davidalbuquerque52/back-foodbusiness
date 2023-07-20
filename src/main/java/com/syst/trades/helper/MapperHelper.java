package com.syst.trades.helper;

import com.syst.trades.dto.get.AddressResponse;
import com.syst.trades.dto.get.ClientResponse;
import com.syst.trades.dto.get.ClientTradeDebitResponse;
import com.syst.trades.dto.get.ClientTradeResponse;
import com.syst.trades.dto.get.HistoryProductQuantityResponse;
import com.syst.trades.dto.get.PaymentModeResponse;
import com.syst.trades.dto.get.ProductResponse;
import com.syst.trades.dto.get.ProductSaleResponse;
import com.syst.trades.dto.get.SaleResponse;
import com.syst.trades.dto.get.StatusResponse;
import com.syst.trades.dto.get.TradeResponse;
import com.syst.trades.dto.post.AddressCreate;
import com.syst.trades.dto.post.ClientCreate;
import com.syst.trades.dto.post.ClientTradeCreate;
import com.syst.trades.dto.post.ClientTradeDebitCreate;
import com.syst.trades.dto.post.HistoryProductQuantityCreate;
import com.syst.trades.dto.post.PaymentModeCreate;
import com.syst.trades.dto.post.ProductCreate;
import com.syst.trades.dto.post.ProductSaleCreate;
import com.syst.trades.dto.post.SaleCreate;
import com.syst.trades.dto.post.StatusCreate;
import com.syst.trades.dto.post.TradeCreate;
import com.syst.trades.model.Address;
import com.syst.trades.model.Client;
import com.syst.trades.model.ClientTrade;
import com.syst.trades.model.ClientTradeDebit;
import com.syst.trades.model.HistoryProductQuantity;
import com.syst.trades.model.PaymentMode;
import com.syst.trades.model.Product;
import com.syst.trades.model.ProductSale;
import com.syst.trades.model.Sale;
import com.syst.trades.model.Status;
import com.syst.trades.model.Trade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MapperHelper {

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse mapToAddressResponse(Address address) {
        return Objects.isNull(address) ? null : modelMapper.map(address, AddressResponse.class);
    }

    public Address mapToAddress(AddressCreate addressCreate) {
        return modelMapper.map(addressCreate, Address.class);
    }

    public List<AddressResponse> mapToAddressResponseList(List<Address> addresses) {
        return addresses.stream().map(address -> mapToAddressResponse(address)).collect(Collectors.toList());
    }

    public ClientResponse mapToClientResponse(Client Client) {
        return Objects.isNull(Client) ? null : modelMapper.map(Client, ClientResponse.class);
    }

    public Client mapToClient(ClientCreate ClientCreate) {
        return modelMapper.map(ClientCreate, Client.class);
    }

    public List<ClientResponse> mapToClientResponseList(List<Client> Clients) {
        return Clients.stream().map(Client -> mapToClientResponse(Client)).collect(Collectors.toList());
    }

    public ClientTradeResponse mapToClientTradeResponse(ClientTrade clientTrade) {
        return Objects.isNull(clientTrade) ? null : modelMapper.map(clientTrade, ClientTradeResponse.class);
    }

    public ClientTrade mapToClientTrade(ClientTradeCreate clientTradeCreate) {
        return modelMapper.map(clientTradeCreate, ClientTrade.class);
    }

    public List<ClientTradeResponse> mapToClientTradeResponseList(List<ClientTrade> clientTrades) {
        return clientTrades.stream().map(ClientTrade -> mapToClientTradeResponse(ClientTrade)).collect(Collectors.toList());
    }

    public ClientTradeDebitResponse mapToClientTradeDebitResponse(ClientTradeDebit clientTradeDebit) {
        return Objects.isNull(clientTradeDebit) ? null : modelMapper.map(clientTradeDebit, ClientTradeDebitResponse.class);
    }

    public ClientTradeDebit mapToClientTradeDebit(ClientTradeDebitCreate clientTradeDebitCreate) {
        return modelMapper.map(clientTradeDebitCreate, ClientTradeDebit.class);
    }

    public List<ClientTradeDebitResponse> mapToClientTradeDebitResponseList(List<ClientTradeDebit> clientTradeDebits) {
        return clientTradeDebits.stream().map(ClientTradeDebit -> mapToClientTradeDebitResponse(ClientTradeDebit)).collect(Collectors.toList());
    }

    public HistoryProductQuantityResponse mapToHistoryProductQuantityResponse(HistoryProductQuantity historyProductQuantity) {
        return Objects.isNull(historyProductQuantity) ? null : modelMapper.map(historyProductQuantity, HistoryProductQuantityResponse.class);
    }

    public HistoryProductQuantity mapToHistoryProductQuantity(HistoryProductQuantityCreate historyProductQuantityCreate) {
        return modelMapper.map(historyProductQuantityCreate, HistoryProductQuantity.class);
    }

    public List<HistoryProductQuantityResponse> mapToHistoryProductQuantityResponseList(List<HistoryProductQuantity> historyProductQuantities) {
        return historyProductQuantities.stream().map(HistoryProductQuantity -> mapToHistoryProductQuantityResponse(HistoryProductQuantity)).collect(Collectors.toList());
    }

    public PaymentModeResponse mapToPaymentModeResponse(PaymentMode paymentMode) {
        return Objects.isNull(paymentMode) ? null : modelMapper.map(paymentMode, PaymentModeResponse.class);
    }

    public PaymentMode mapToPaymentMode(PaymentModeCreate paymentModeCreate) {
        return modelMapper.map(paymentModeCreate, PaymentMode.class);
    }

    public List<PaymentModeResponse> mapToPaymentModeResponseList(List<PaymentMode> paymentModes) {
        return paymentModes.stream().map(paymentMode -> mapToPaymentModeResponse(paymentMode)).collect(Collectors.toList());
    }

    public ProductResponse mapToProductResponse(Product product) {
        return Objects.isNull(product) ? null : modelMapper.map(product, ProductResponse.class);
    }

    public Product mapToProduct(ProductCreate productCreate) {
        return modelMapper.map(productCreate, Product.class);
    }

    public List<ProductResponse> mapToProductResponseList(List<Product> products) {
        return products.stream().map(product -> mapToProductResponse(product)).collect(Collectors.toList());
    }

    public ProductSaleResponse mapToProductSaleResponse(ProductSale productSale) {
        return Objects.isNull(productSale) ? null : modelMapper.map(productSale, ProductSaleResponse.class);
    }

    public ProductSale mapToProductSale(ProductSaleCreate productSaleCreate) {
        return modelMapper.map(productSaleCreate, ProductSale.class);
    }

    public List<ProductSaleResponse> mapToProductSaleResponseList(List<ProductSale> productSales) {
        return productSales.stream().map(productSale -> mapToProductSaleResponse(productSale)).collect(Collectors.toList());
    }

    public SaleResponse mapToSaleResponse(Sale sale) {
        return Objects.isNull(sale) ? null : modelMapper.map(sale, SaleResponse.class);
    }

    public Sale mapToSale(SaleCreate saleCreate) {
        return modelMapper.map(saleCreate, Sale.class);
    }

    public List<SaleResponse> mapToSaleResponseList(List<Sale> sales) {
        return sales.stream().map(sale -> mapToSaleResponse(sale)).collect(Collectors.toList());
    }

    public StatusResponse mapToStatusResponse(Status status) {
        return Objects.isNull(status) ? null : modelMapper.map(status, StatusResponse.class);
    }

    public Status mapToStatus(StatusCreate statusCreate) {
        return modelMapper.map(statusCreate, Status.class);
    }

    public List<StatusResponse> mapToStatusResponseList(List<Status> statuss) {
        return statuss.stream().map(status -> mapToStatusResponse(status)).collect(Collectors.toList());
    }

    public TradeResponse mapToTradeResponse(Trade trade) {
        return Objects.isNull(trade) ? null : modelMapper.map(trade, TradeResponse.class);
    }

    public Trade mapToTrade(TradeCreate tradeCreate) {
        return modelMapper.map(tradeCreate, Trade.class);
    }

    public List<TradeResponse> mapToTradeResponseList(List<Trade> trades) {
        return trades.stream().map(trade -> mapToTradeResponse(trade)).collect(Collectors.toList());
    }

}