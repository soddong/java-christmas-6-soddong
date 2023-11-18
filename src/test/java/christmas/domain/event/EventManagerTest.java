package christmas.domain.event;

class EventManagerTest {
//    EventManager eventManager;
//    List<DiscountPolicy> discountPolicies = new ArrayList<>();
//    List<GiftPolicy> giftPolicies = new ArrayList<>();
//    ItemDto item;
//    OrdersDto orders = new OrdersDto(LocalDate.of(2023,12,25));
//
//    @BeforeEach
//    void setUp() {
//        item = ItemDto.createItem("샴페인", "1");
//        discountPolicies.add(new WeekdaysDiscountPolicy()); // 디저트 2023원
//        discountPolicies.add(new SpecialDiscountPolicy()); // 무조건 1000
//        giftPolicies.add(new FoodGiftPolicy(item, 10_000));
//        eventManager = new EventManager(discountPolicies, giftPolicies);
//
//        orders.addOrder(ItemDto.createItem("초코케이크", "2"));
//    }
//
//    @Test
//    void 할인_정책들을_모두_계산할수있다() {
//        // when & then
//        assertThat(eventManager.sumDiscounts(orders))
//                .isEqualTo(2*2023+1000);
//    }
//
//    @Test
//    void 증정품들을_얻을수_있다() {
//        // when & then
//        assertThat(eventManager.receiveGifts(orders))
//                .containsExactly(item);
//    }
}